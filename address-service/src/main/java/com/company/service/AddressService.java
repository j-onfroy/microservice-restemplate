package com.company.service;

import com.company.dto.AddressResponse;
import com.company.entity.Address;
import com.company.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final RabbitTemplate rabbitTemplate;

    public AddressResponse findAddressByEmployeeId(int employeeId) {
        Optional<Address> address = addressRepository.findAllByEmployeeId(employeeId);
        Address address1 = address.get();

        sendNotificationAboutEmail(address1);

        return AddressResponse.builder()
                .id(address1.getId())
                .state(address1.getState())
                .city(address1.getCity())
                .build();

    }

    private void sendNotificationAboutEmail(Address address1) {
        new Thread(() -> {
            rabbitTemplate.convertAndSend("address-exchange", "address-routingKey", address1.getId().toString());
            rabbitTemplate.convertAndSend("address-exchange", "for-only-shipping", address1);
        }).start();
    }

}
