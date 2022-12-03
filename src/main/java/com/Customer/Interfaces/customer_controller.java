package com.Customer.Interfaces;

import java.util.List;

import com.Product_Management.Entity.customer;

public interface customer_controller {

	public List getcustomerbyid(int id);

	public String addcustomer(customer c);

	public String updatecustomer(customer c);

	public String deletecustomer(int id);

	public List getonlycustomers();

	public List getallcustomers();

	public List customerOrder();

}
