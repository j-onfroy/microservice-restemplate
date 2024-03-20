package com.company.service;

import com.company.dto.AddressResponse;
import com.company.entity.Address;
import com.company.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;

    public AddressResponse findAddressByEmployeeId(int employeeId) {
        Optional<Address> address = addressRepository.findAllByEmployeeId(employeeId);
        Address address1 = address.get();
        return AddressResponse.builder()
                .id(address1.getId())
                .state(address1.getState())
                .city(address1.getCity())
                .build();
    }

}
