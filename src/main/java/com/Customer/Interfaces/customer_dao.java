package com.Customer.Interfaces;

import java.util.List;

import com.Product_Management.Entity.customer;

public interface customer_dao {

	public List getcustomerbyid(int id);

	public String addcustomer(customer c);

	public String updatecustomers(customer c);

	public String deletecustomerbyid(int id);

	public List getonlycustomers();

	public List getallcustomers();

	public List customerOrder();



}
