package com.company.config;

import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class LoadBalancerConfiguration {

 /*   @Bean
    public ServiceInstanceListSupplier instanceSupplier(ConfigurableApplicationContext applicationContext) {
        return ServiceInstanceListSupplier.builder()
                .withDiscoveryClient()
                .withHealthChecks()
                .build(applicationContext);
    }*/
}
