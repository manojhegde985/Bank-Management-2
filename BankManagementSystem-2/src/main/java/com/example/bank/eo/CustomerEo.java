package com.example.bank.eo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.bank.dto.CustomerDto;
import com.example.bank.feignclient.FeignClient1;
import com.example.bank.resttemplate.RestTemplate1;

@Component
public class CustomerEo implements ICustomerEo{
	@Autowired
	private FeignClient1 feignClient;
	
	@Autowired
	private RestTemplate1 restTemplate;

	@Override
	public List<CustomerDto> getAll() {
		logger.info("fetched data in EO by REST TEMPLATE");
		return restTemplate.getusers();
	}

	@Override
	public List<CustomerDto> getCustomer() {
		
		 return feignClient.getCustomer();
	}

}
