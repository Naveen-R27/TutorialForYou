package com.example.user.input;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table
public class User {
	@Id
	@Column
	
	@NotEmpty
	private String firstname;
	
	@NotEmpty
	private String lastname;
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@NotEmpty
	private String password;
	
	@NotEmpty
	@Email
	private String email;

	
	public User(String firstname, String lastname, String password, String email) {
		this.firstname=firstname;
		this.lastname=lastname;
		this.password=password;
		this.email=email;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
