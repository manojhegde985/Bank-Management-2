package com.example.bank.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bank.BankManagementSystem2Application;
import com.example.bank.bo.CustomerBo;
import com.example.bank.entity.Customer;
import com.example.bank.mapstruct.Mapstruct;



@Service
public class CustomerService implements ICustomerService{
	@Autowired
	private CustomerBo bo;
	@Autowired
	private Mapstruct mapstruct;

	private static final Logger logger = LoggerFactory.getLogger(BankManagementSystem2Application.class);

	public String ServiceLog() {
		logger.info("this is a bank management entity file ");

		return "ServiceLog";
	}

	@Override
	public List<Customer> getAll() {
		logger.info("fetched data in service by REST TEMPLATE");
		return mapstruct.customerDtoToCustomerList(bo.getAll());
	}

	@Override
	public List<Customer> getCustomer() {
		logger.info("fetched data in service by REST TEMPLATE");
		return mapstruct.customerDtoToCustomerList(bo.getCustomer());
	}

}
