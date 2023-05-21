package com.example.user.course;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table

public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column
	
	@NotEmpty
	private String cname;
	@NotEmpty
	private String cprovider;
	@NotEmpty
	private int price;
	
	public Course() {}
	
	
	
	
	public Course(long id, String cname, String cprovider,int price) {
		super();
		this.id = id;
		this.cname = cname;
		this.cprovider = cprovider;
		this.price = price;
	}




	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCprovider() {
		return cprovider;
	}
	public void setCprovider(String cprovider) {
		this.cprovider = cprovider;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	

}
