package com.sanjayacchana.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanjayacchana.springdemo.dao.CustomerDAO;
import com.sanjayacchana.springdemo.entity.Customer;
@Service
public class CustomerServiceImpl implements CustomerService{
	
	//need to inject customer dao
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public List<Customer> geCustomers() {
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void  saveCustomer(Customer theCustomer) {
		
		 customerDAO.saveCustomer(theCustomer);
	}

	@Override
	@Transactional
	public Customer geCustomers(int theId) {
		return customerDAO.getCustomers(theId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		
		customerDAO.deleteCustomer(theId);
		
	}

	@Override
    @Transactional
    public List<Customer> searchCustomers(String theSearchName) {

        return customerDAO.searchCustomers(theSearchName);
    }

	
	

}
