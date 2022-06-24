package com.example.bank.bo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.bank.BankManagementSystem2Application;
import com.example.bank.dto.CustomerDto;
import com.example.bank.eo.CustomerEo;
import com.example.bank.mapstruct.Mapstruct;


@Service
public class CustomerBo implements ICustomerBo{

	@Autowired
	private CustomerEo eo;
	@Autowired
	private Mapstruct mapstruct;
	
	private static final Logger logger = LoggerFactory.getLogger(BankManagementSystem2Application.class);
	public String ServiceLog() {
	logger.info("this is a bank management entity file ");
	return "ServiceLog";
	}
	@Override
	public List<CustomerDto> getAll() {
		logger.info("fetched data in EO by REST TEMPLATE");

		return eo.getAll();
	}

	@Override
	public List<CustomerDto> getCustomer() {
		logger.info("fetched data in EO by FEIGN CLIENT");
		return eo.getCustomer();
	}

}
