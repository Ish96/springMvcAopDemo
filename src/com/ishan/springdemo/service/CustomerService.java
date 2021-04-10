package com.ishan.springdemo.service;

import java.util.List;

import com.ishan.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int tempId);

	public void deleteCustomer(int tempId);
	
}
