package com.mphasis.training.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
	private int pid;
	private String pname;
	private double cost;
	private int qty;
	
	public Product() {
		
	}
	public Product(int pid, String pname, double cost, int qty) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.cost = cost;
		this.qty = qty;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", cost=" + cost + ", qty=" + qty + "]";
	}
	
}
