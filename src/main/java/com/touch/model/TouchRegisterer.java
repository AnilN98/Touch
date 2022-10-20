package com.touch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="touchregisters")
public class TouchRegisterer 
{
	public TouchRegisterer() {
		
	}

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	String id;
	
	@Column(name="registerName")
	private String name;
	
	@Column(name="registerPassword")
	private String password;
	
	@Column(name="registerEmail")
	private String email;
	
	@Column(name="registerMobile")
	private String mobileNumber;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "TouchRegisterer [name=" + name + ", password=" + password + ", email=" + email + ", mobileNumber="
				+ mobileNumber + "]";
	}

	public TouchRegisterer(String name, String password, String email, String mobileNumber) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.mobileNumber = mobileNumber;
	}
	
	public TouchRegisterer(String email, String password)
	{
		super();
		this.email = email;
		this.password = password;
	}
	
	
	
	

}
