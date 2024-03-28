package com.company.config;

import feign.Contract;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AddressConfig {
    @Bean
    public Contract feignContract() {
        return new SpringMvcContract();
    }
}
