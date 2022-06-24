package com.example.bank.mapstruct;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.bank.dto.CustomerDto;
import com.example.bank.entity.Customer;


@Mapper(componentModel="spring")
public interface Mapstruct {
	List<Customer> customerDtoToCustomerList(List<CustomerDto> list);
	
	
}
