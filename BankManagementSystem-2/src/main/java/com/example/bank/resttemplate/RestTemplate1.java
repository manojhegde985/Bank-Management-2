package com.example.bank.resttemplate;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.bank.config.ConfigClass;
import com.example.bank.dto.CustomerDto;

@Component
public class RestTemplate1 {
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ConfigClass configclass;


	public List<CustomerDto> getusers()
	{
	CustomerDto[] objects = restTemplate.getForObject(configclass.getUrl(), CustomerDto[].class);
	return Arrays.asList(objects);
	}


	
}
