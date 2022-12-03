package com.Product_Management.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Customer.Interfaces.customer_controller;
import com.Product_Management.Entity.customer;
import com.Product_Management.Service.Customer_Service;

@RequestMapping("customer")
@RestController
public class Customer_Controller implements customer_controller {

	@Autowired
	Customer_Service service;

//	Get Customer By Id
	@Override
	@GetMapping("{id}")
	public List getcustomerbyid(@PathVariable int id) {
		return service.getcustomerbyid(id);
	}

//	Add New Customer
	@Override
	@PostMapping("add")
	public String addcustomer(@RequestBody customer c) {
		return service.addcustomer(c);
	}

//	Update Existing Customer
	@Override
	@PutMapping("update/{id}")
	public String updatecustomer(@RequestBody customer c) {
		return service.updatecustomer(c);
	}

//	Delete Customer BY Id
	@Override
	@DeleteMapping("delete/{id}")
	public String deletecustomer(@PathVariable int id) {
		return service.deletecustomer(id);
	}

//	Get All Customers List
	@Override
	@GetMapping("getall")
	public List getonlycustomers() {
		return service.getonlycustomers();
	}

//	Get All List With Customer And Products
	@Override
	@GetMapping("list")
	public List<customer> getallcustomers() {
		return service.getallcustomers();
	}

//	Get All Orders
	@Override
	@GetMapping("orders")
	public List customerOrder() {
		return service.customerOrder();
	}



}
