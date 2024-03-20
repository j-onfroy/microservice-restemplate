package com.company.customer.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("CUSTOMER")
public interface CustomerInterface {
}
