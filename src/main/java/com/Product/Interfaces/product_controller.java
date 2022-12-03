package com.Product.Interfaces;

import java.util.List;

import com.Product_Management.Entity.product;

public interface product_controller {

	public List getallproduct();

	public List getproductbyid(int id);

	public String addproduct(product p);

	public String updateproductbyid(product p);

	public String deleteproductbyid(int id);
}
