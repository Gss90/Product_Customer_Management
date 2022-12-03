package com.Product_Management.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Product.Interfaces.product_service;
import com.Product_Management.Entity.product;
import com.Product_Management.Repository.Product_Dao;

@Service
public class Product_Service implements product_service {

	@Autowired
	Product_Dao dao;

	@Override
	public List getallproduct() {
		// TODO Auto-generated method stub
		return dao.getallproduct();
	}

	@Override
	public List getproductbyid(int id) {
		return dao.getproductbyid(id);
	}

	@Override
	public String addproduct(product p) {
		return dao.addproduct(p);
	}
	
	@Override
	public String updateproductbyid(product p) {
		return dao.updateproductbyid(p);
	}
	
	@Override
	public String deleteproductbyid(int id) {
		return dao.deleteproductbyid(id);
	}

}
