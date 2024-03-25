package com.company.employee.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponse {
    private int id;
    private String name;
    private String email;
    private Integer age;
    private AddressResponse addressResponse;
}
