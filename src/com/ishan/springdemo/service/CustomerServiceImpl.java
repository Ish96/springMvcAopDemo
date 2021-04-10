package com.ishan.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ishan.entity.Customer;
import com.ishan.springdemo.dao.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService {

	//Autowiring Customer Dao
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDao.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		customerDao.saveCustomer(customer);		
	}

	@Override
	@Transactional
	public Customer getCustomer(int tempId) {
		return customerDao.getCustomer(tempId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int tempId) {
		customerDao.deleteCustomer(tempId);
		
	}

}
