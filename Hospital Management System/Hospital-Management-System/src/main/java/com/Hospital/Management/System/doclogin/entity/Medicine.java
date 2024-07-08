package com.Hospital.Management.System.doclogin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Medicine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String drugName;
	private String Stock;
	public Medicine() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Medicine(long id, String drugName, String stock) {
		super();
		this.id = id;
		this.drugName = drugName;
		Stock = stock;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDrugName() {
		return drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	public String getStock() {
		return Stock;
	}
	public void setStock(String stock) {
		Stock = stock;
	}
	
	
	
	
}
