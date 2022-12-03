package com.Product_Management.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.Customer.Interfaces.customer_dao;
import com.Product_Management.Entity.customer;

@Repository
public class Customer_Dao implements customer_dao {

	@Autowired
	SessionFactory fact;

//	Add New Customer
	@Override
	public String addcustomer(customer c) {
		Session session = fact.openSession();
		Transaction tr = session.beginTransaction();
		session.save(c);
		tr.commit();
		return "Added Customer SuccesFully";
	}

//	Update Customer By Id
	@Override
	public String updatecustomers(customer c) {
		Session session = fact.openSession();
		Transaction tr = session.beginTransaction();
		session.update(c);
		tr.commit();
		return "Updated Customer SuccesFully";
	}

//	Delete Customer By Id
	@Override
	public String deletecustomerbyid(int id) {
		Session session = fact.openSession();
		customer c = session.load(customer.class, id);
		Transaction tr = session.beginTransaction();
		session.delete(c);
		tr.commit();
		return "Deleted Customer SuccesFully";
	}

//	Get Customer By Id
	@Override
	public List getcustomerbyid(int id) {
		Session session = fact.openSession();
		NativeQuery<Object[]> query = session.createNativeQuery("select customer.customer_id,customer.customer_name,customer.customer_city,product.product_id,product.product_name,product.product_price,customer.order_id from customer,product where customer.product_id=product.product_id and customer.customer_id=:a");
		query.setParameter("a", id);
		List<Object[]> list1 = query.list();
		ArrayList<HashMap<String, Object>> list = new ArrayList<>();
		for (Object[] object : list1) {
			LinkedHashMap<String, Object> map = new LinkedHashMap<>();
			map.put("customer_id", object[0]);
			map.put("customer_name", object[1]);
			map.put("customer_city", object[2]);
			map.put("product_id", object[3]);
			map.put("product_name", object[4]);
			map.put("product_price", object[5]);
			map.put("order_id", object[6]);
			list.add(map);
		}
		return list;
	}

//	Get Only Customers
	@Override
	public List getonlycustomers() {
		Session session = fact.openSession();
		NativeQuery<Object[]> query = session.createNativeQuery("select customer.customer_id,customer.customer_name,customer.customer_city from customer");
		List<Object[]> list1 = query.list();
		ArrayList<HashMap<String, Object>> list = new ArrayList<>();
		for (Object[] object : list1) {
			LinkedHashMap<String, Object> map = new LinkedHashMap<>();
			map.put("customer_id", object[0]);
			map.put("customer_name", object[1]);
			map.put("customer_city", object[2]);
			list.add(map);
		}
		return list;
	}

//	Get All Customers
	@Override
	public List getallcustomers() {
		Session session = fact.openSession();
		NativeQuery<Object[]> query = session.createNativeQuery("select customer.customer_id,customer.customer_name,customer.customer_city,product.product_id,product.product_name,product.product_price,customer.order_id from customer ,product where customer.product_id=product.product_id");
		List<Object[]> list1 = query.list();
		ArrayList<HashMap<String, Object>> list = new ArrayList<>();
		for (Object[] object : list1) {
			LinkedHashMap<String, Object> map = new LinkedHashMap<>();
			map.put("customer_id", object[0]);
			map.put("customer_name", object[1]);
			map.put("customer_city", object[2]);
			map.put("product_id", object[3]);
			map.put("product_name", object[4]);
			map.put("product_price", object[5]);
			map.put("order_id", object[6]);
			list.add(map);
		}
		return list;
	}

//	Customer Orders List
	@Override
	public List customerOrder() {
		Session session = fact.openSession();
		NativeQuery<Object[]> query = session.createNativeQuery("select customer.customer_id,customer.product_id,product.product_price,customer.order_id from customer,product where customer.product_id=product.product_id");
		List<Object[]> list1 = query.list();
		ArrayList<HashMap<String, Object>> list = new ArrayList<>();
		for (Object[] object : list1) {
			LinkedHashMap<String, Object> map = new LinkedHashMap<>();
			map.put("customer_id", object[0]);
			map.put("product_id", object[1]);
			map.put("product_price", object[2]);
			map.put("order_id", object[3]);
			list.add(map);
		}
		return list;
	}

}
