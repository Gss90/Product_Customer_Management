package com.Product_Management.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class product {

	@Id
	int product_id;
	String product_name;
	String product_price;

	public product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public product(int product_id, String product_name, String product_price) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_price = product_price;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_price() {
		return product_price;
	}

	public void setProduct_price(String product_price) {
		this.product_price = product_price;
	}

	@Override
	public String toString() {
		return "product [product_id=" + product_id + ", product_name=" + product_name + ", product_price="
				+ product_price + "]";
	}

}
