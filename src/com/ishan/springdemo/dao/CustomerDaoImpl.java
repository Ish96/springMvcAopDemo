package com.ishan.springdemo.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ishan.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		//Get hibernate Session
		//Create Query	
		//Execute Query
		//Return List of Customers
		Session session = sessionFactory.getCurrentSession();
		
		Query<Customer> query = session.createQuery("from Customer order by lastName", Customer.class);
		
		List<Customer> customers = query.list();
		
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		//get current session
		//save the customer
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(customer);
		
	}

	@Override
	public Customer getCustomer(int tempId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Customer customer = currentSession.get(Customer.class, tempId);
		return customer;
	}

	@Override
	public void deleteCustomer(int tempId) {
		//get Current session
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("delete from Customer where id=:theCustomerId");
		query.setParameter("theCustomerId", tempId);
		query.executeUpdate();
		
	}

}
