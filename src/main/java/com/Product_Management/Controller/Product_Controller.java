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

import com.Product.Interfaces.product_controller;
import com.Product_Management.Entity.product;
import com.Product_Management.Service.Product_Service;

@RequestMapping("product")
@RestController
public class Product_Controller implements product_controller {

	@Autowired
	Product_Service service;

//	Get Product By Id
	@Override
	@GetMapping("{id}")
	public List getproductbyid(@PathVariable int id) {
		return service.getproductbyid(id);
	}

//	Add New Product
	@Override
	@PostMapping("add") 
	public String addproduct(@RequestBody product p) {
		return service.addproduct(p);
	}

//	Update Existing Product
	@Override
	@PutMapping("update/{id}")
	public String updateproductbyid(@RequestBody product p) {
		return service.updateproductbyid(p);
	}

//	Delete Product By Id
	@Override
	@DeleteMapping("delete/{id}") 
	public String deleteproductbyid(@PathVariable int id) {
		return service.deleteproductbyid(id);
	}

//	Get All Products List
	@Override
	@GetMapping("getall") 
	public List getallproduct() {
		return service.getallproduct();
	}

}
