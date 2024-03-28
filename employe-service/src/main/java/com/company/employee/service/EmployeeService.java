package com.company.employee.service;

import com.company.employee.dto.AddressResponse;
import com.company.employee.dto.EmployeeResponse;
import com.company.employee.entity.Employee;
import com.company.employee.feignclient.AddressClient;
import com.company.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final AddressClient addressClient;
    private final RabbitTemplate rabbitTemplate;

    public EmployeeResponse getEmployeeById(int id) {
        Optional<Employee> emp = employeeRepository.findById(id);
        Employee employee = emp.get();
        EmployeeResponse employeeResponse = EmployeeResponse.builder()
                .id(employee.getId())
                .age(employee.getAge())
                .name(employee.getName())
                .email(employee.getEmail())
                .build();

        sendNotificationAboutEmail(employee);

        ResponseEntity<AddressResponse> address = addressClient.getAddressByEmployeeId(id);
        employeeResponse.setAddressResponse(address.getBody());
        return employeeResponse;
    }

    private void sendNotificationAboutEmail(Employee employee) {
        new Thread(() -> {
            rabbitTemplate.convertAndSend("employee-exchange", "employee-routingKey", employee.getId().toString());
            rabbitTemplate.convertAndSend("employee-exchange", "for-only-shipping", employee);
        }).start();
    }
}
