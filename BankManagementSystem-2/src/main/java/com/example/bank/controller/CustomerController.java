package com.example.bank.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bank.entity.Customer;
import com.example.bank.service.ICustomerService;
import com.example.bank.util.UtilClass;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@RestController
@RequestMapping(value = "/customer")
@EnableFeignClients
@ControllerAdvice
public class CustomerController {
	private static final String CUSTOMERBYRESTTEMPLATE ="getAllMethod";

	private static final String CUSTOMERBYFEIGNCLIENT ="getAllByFeign" ;

	@Autowired
	private ICustomerService userService;
	
	private final Logger logger = LoggerFactory.getLogger(CustomerController.class);
   
    String controller(){
       
        logger.info("This is a bank management controller layer");
        return "controller";
    }
    
    @GetMapping(value=UtilClass.GET)
    @CircuitBreaker(name=CUSTOMERBYRESTTEMPLATE, fallbackMethod="getAllMethod")
    public ResponseEntity<List<Customer>> getAll()
    {
    List<Customer> allCustomers = userService.getAll();
    logger.info("fetched data in controller by REST TEMPLATE");
    return new ResponseEntity<List<Customer>>(allCustomers , HttpStatus.OK);

    }
    
    public ResponseEntity<String> getAllMethod(Exception e){
    	 return new ResponseEntity<String>("customer_service_is_down" , HttpStatus.OK);
    }
    
    //Feign client
    @GetMapping(value=UtilClass.GET1)
    @CircuitBreaker(name=CUSTOMERBYFEIGNCLIENT, fallbackMethod="getAllByFeign")
    public ResponseEntity<List<Customer>> getAllCustomers() {
    	 List<Customer> allCustomer = userService.getCustomer();
    	    logger.info("fetched data in controller by FEIGN CLIENT");
    	    return new ResponseEntity<List<Customer>>(allCustomer, HttpStatus.OK);
    
    }
    
    public ResponseEntity<String> getAllByFeign(Exception e){
   	 return new ResponseEntity<String>("customer_service_feign_client_down" , HttpStatus.OK);
   }
    
    
}
