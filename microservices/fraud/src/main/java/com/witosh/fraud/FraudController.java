package com.witosh.fraud;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
@Slf4j
public class FraudController {

	private  final FraudCheckService checkService;
	
	@GetMapping(path = "{customerId}")
	public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId) {
		boolean isFraudulentCustomer = checkService.isFraudulentCustomer(customerId);
		return new FraudCheckResponse(isFraudulentCustomer);
	}
}
