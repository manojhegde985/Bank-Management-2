package com.example.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import com.example.bank.dto.CustomerDto;
import com.example.bank.entity.Bank;
import com.example.bank.feignclient.FeignClient1;
import com.example.bank.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.java.Before;

@SpringBootTest
@AutoConfigureMockMvc
class BankManagementSystem2ApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private RestTemplate restTemplate=  mock(RestTemplate.class);
	
	@Autowired
	private FeignClient1 feignClient;
	
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext context;

	@MockBean
	private CustomerService service;

	ObjectMapper om = new ObjectMapper();
	
	@Before
	private void setUp()
	{
	mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void getCustomerTest() throws Exception
	{
	Bank[] objects = new Bank[2];
	objects[0] = new Bank(1,"Manoj","H","Bangalore","manoj","1234");
	objects[1] = new Bank(2,"John","L","Bangalore","john","1020");

	Mockito.when( restTemplate.getForObject(any(String.class),any(Class.class))).thenReturn(objects);
	mockMvc.perform(get("/customer/getAllCustomer")).andExpect(status().isOk());
	assertEquals(objects.length , 2);

	}
	
	@Test
	public void getCustomerbyFeignTest() throws Exception
	{

	List<CustomerDto> customer = new ArrayList<CustomerDto>();
	CustomerDto customer1 = new CustomerDto(1,"John","L","Bangalore","john","1020");
	CustomerDto customer2 = new CustomerDto(2,"Manoj","H","Bangalore","manoj","1234");
	customer.add(customer2);
	customer.add(customer1);
	when( feignClient.getCustomer()).thenReturn(customer);
	mockMvc.perform(get("/customer/getAll")).andExpect(status().isOk());
	//assertEquals(customer. , 1);

	}

}
