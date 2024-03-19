package com.company.fraud;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
@RequiredArgsConstructor
public class FraudController {
    private final FraudCheckService fraudCheckService;

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId) {
        boolean idFraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerId);
        return  new FraudCheckResponse(idFraudulentCustomer);
    }
}
