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

import com.Product.Interfaces.product_dao;
import com.Product_Management.Entity.product;

@Repository
public class Product_Dao implements product_dao {

	@Autowired
	SessionFactory fact;

//	Get Product By Id
	@Override
	public List getproductbyid(int id) {
		Session session = fact.openSession();
		NativeQuery<Object[]> query = session.createNativeQuery("select * from product where product_id=:a");
		query.setParameter("a", id);
		List<Object[]> list1 = query.list();
		ArrayList<HashMap<String, Object>> list = new ArrayList<>();
		for (Object[] object : list1) {
			LinkedHashMap<String, Object> map = new LinkedHashMap<>();
			map.put("product_id", object[0]);
			map.put("product_name", object[1]);
			map.put("product_price", object[2]);
			list.add(map);
		}
		return list;
	}

//	Add New Product
	@Override
	public String addproduct(product p) {
		Session session = fact.openSession();
		Transaction tr = session.beginTransaction();
		session.save(p);
		tr.commit();
		return "Added Product SuccesFully";
	}

//	Update Product
	@Override
	public String updateproductbyid(product p) {
		Session session = fact.openSession();
		Transaction tr = session.beginTransaction();
		session.update(p);
		tr.commit();
		return "Updated Product SuccesFully";
	}

//	Delete Product By Id
	@Override
	public String deleteproductbyid(int id) {
		Session session = fact.openSession();
		Transaction tr = session.beginTransaction();
		product p = session.load(product.class, id);
		session.delete(p);
		tr.commit();
		return "Deleted Product Succesfully";
	}

//	Get All Products
	@Override
	public List getallproduct() {
		Session session = fact.openSession();
		NativeQuery<Object[]> query = session.createNativeQuery("select * from product");
		List<Object[]> list1 = query.list();
		ArrayList<HashMap<String, Object>> list = new ArrayList<>();
		for (Object[] object : list1) {
			LinkedHashMap<String, Object> map = new LinkedHashMap<>();
			map.put("product_id", object[0]);
			map.put("product_name", object[1]);
			map.put("product_price", object[2]);
			list.add(map);
		}
		return list;
	}

}
