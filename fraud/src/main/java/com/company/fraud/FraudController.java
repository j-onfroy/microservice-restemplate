package com.company.fraud;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
@RequiredArgsConstructor
@Slf4j
public class FraudController {
    private final FraudCheckService fraudCheckService;

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId) {
        boolean idFraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerId);
        log.info("fraud check {}", customerId);
        return new FraudCheckResponse(idFraudulentCustomer);
    }
}
