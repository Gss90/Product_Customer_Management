package com.Product.Interfaces;

import java.util.List;

import com.Product_Management.Entity.product;

public interface product_service {

	public List getallproduct();

	public List getproductbyid(int id);

	public String addproduct(product p);

	public String updateproductbyid(product p);

	public String deleteproductbyid(int id);

}
