package com.example.bank.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.bank.BankManagementSystem2Application;
import com.example.bank.entity.Customer;


public interface ICustomerService {
	static final Logger logger = LoggerFactory.getLogger(BankManagementSystem2Application.class);
	  public default String ServiceLog() {
		logger.info("this is a bank management entity file ");
		return "ServiceLog";
		}

	public List<Customer> getAll();
	
	public List<Customer> getCustomer();
}
