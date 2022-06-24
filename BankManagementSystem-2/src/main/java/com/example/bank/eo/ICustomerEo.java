package com.example.bank.eo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.bank.BankManagementSystem2Application;
import com.example.bank.dto.CustomerDto;



public interface ICustomerEo {
	static final Logger logger = LoggerFactory.getLogger(BankManagementSystem2Application.class);
	  public default String ServiceLog() {
		logger.info("this is a bank management eo file ");
		return "ServiceLog";
		}

	
	public List<CustomerDto> getAll();
	
	public List<CustomerDto> getCustomer();
	
}
