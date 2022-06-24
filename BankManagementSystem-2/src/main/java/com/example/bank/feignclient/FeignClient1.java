package com.example.bank.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.bank.dto.CustomerDto;



@FeignClient(name="feign",url="http://localhost:8088/customer/")
public interface FeignClient1 {
	@GetMapping("/getAll")
	public List<CustomerDto> getCustomer();
}
