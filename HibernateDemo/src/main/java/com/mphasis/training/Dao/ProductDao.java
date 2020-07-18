package com.mphasis.training.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.mphasis.training.entities.Product;

public class ProductDao {
  SessionFactory sessionfactory=null;
  
  public ProductDao() {
	  Configuration con= new Configuration().configure().addAnnotatedClass(Product.class);
	  StandardServiceRegistryBuilder builder= new StandardServiceRegistryBuilder().applySettings(con.getProperties());
	  sessionfactory= con.buildSessionFactory(builder.build());
	  
  }
  
  public void insertProduct(Product p) {
	  Session session = sessionfactory.openSession();
	  session.beginTransaction();
	  session.save(p);
	  session.getTransaction().commit();
	  session.close();
	  
	  
  }
  public void updateProduct(Product p) {
	  Session session = sessionfactory.openSession();
	  session.beginTransaction();
	  session.update(p);
	  session.getTransaction();
	  session.close();
	  
	  
  }
  public void deleteProduct(int pid) {
	  
	  Session session=null;
	  try {
	   session = sessionfactory.openSession();
	  session.beginTransaction();
	 Product p=(Product)session.get(Product.class, pid);
	  session.delete(p);
	  session.getTransaction().commit();
	  }catch(Exception e) {
		  session.getTransaction().rollback();
	  }
	  
	  session.close();
	  
	  
  }
  
  public Product retriveProductById(int pid){
	  
	  Session session=sessionfactory.openSession();
	  Product p=(Product)session.get(Product.class, pid);
	return p;
	  
	  
  }
  
 public List<Product> retriveAllProduct(){
	  List<Product> products= new ArrayList<Product>();
	  Session session=sessionfactory.openSession();
	 products= session.createCriteria(Product.class).list();
	return products;
	  
	  
  }
 public List<Product> retriveProductByCost(double cost){
	  List<Product> products= new ArrayList<Product>();
	  Session session=sessionfactory.openSession();
	  Product p=(Product) session.createCriteria(Product.class).add(Restrictions.eq("cost",cost)).list();
	return products;
	  
	  
 }
  
  
}
