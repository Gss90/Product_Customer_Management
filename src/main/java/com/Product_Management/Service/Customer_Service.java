package com.Product_Management.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.Customer.Interfaces.customer_service;
import com.Product_Management.Entity.customer;
import com.Product_Management.Repository.Customer_Dao;

@Service
public class Customer_Service implements customer_service {

	@Autowired
	Customer_Dao dao;

	@Override
	public List getcustomerbyid(int id) {
		return dao.getcustomerbyid(id);
	}

	@Override
	public String addcustomer(customer c) {
		return dao.addcustomer(c);
	}

	@Override
	public String updatecustomer(customer c) {
		return dao.updatecustomers(c);
	}

	@Override
	public String deletecustomer(int id) {
		return dao.deletecustomerbyid(id);
	}

	@Override
	public List getonlycustomers() {
		return dao.getonlycustomers();
	}

	@Override
	public List<customer> getallcustomers() {
		return dao.getallcustomers();
	}

	@Override
	public List customerOrder() {
		return dao.customerOrder();
	}

}
