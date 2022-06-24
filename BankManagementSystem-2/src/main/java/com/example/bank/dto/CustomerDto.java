package com.example.bank.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotEmpty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.annotation.Id;

import com.example.bank.BankManagementSystem2Application;


@javax.persistence.Entity
public class CustomerDto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cid;
	@Column
	@NotEmpty(message="First name is required")
	private String fname;
	@Column
	@NotEmpty(message="Last name is required")
	private String lname;
	@Column
	@NotEmpty(message="Address is required")
	private String address;
	@Column
	@NotEmpty(message="Username is required")
	private String username;
	@Column
	@NotEmpty(message="pasword is required")
	private String password;
	
	private static final Logger logger = LoggerFactory.getLogger(BankManagementSystem2Application.class);
	String EntityLog() {
	logger.info("this is bank management entity file ");
      
	return "EntityLog";
	}
	
	
	public CustomerDto(Integer cid, @NotEmpty(message = "First name is required") String fname,
			@NotEmpty(message = "Last name is required") String lname,
			@NotEmpty(message = "Address is required") String address,
			@NotEmpty(message = "Username is required") String username,
			@NotEmpty(message = "pasword is required") String password) {
		super();
		this.cid = cid;
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.username = username;
		this.password = password;
	}


	public Integer getCid() {
		return cid;
	}


	public void setCid(Integer cid) {
		this.cid = cid;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public static Logger getLogger() {
		return logger;
	}


	public CustomerDto() {
		super();
	}
	
	
	
	
}
