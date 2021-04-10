package com.ishan.springdemo.dao;

import java.util.List;

import com.ishan.entity.Customer;

public interface CustomerDao {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int tempId);

	public void deleteCustomer(int tempId);
}
