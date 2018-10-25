package com.demo.springhibernatedemo.entity;


import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

enum Gender{male,female};

@NamedQueries({
	  @NamedQuery(
	  name="User.searchByCity",
	  query="from User where city = :city"
	  )
	})
@Entity
//@Table(name="user2323")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	
	@Basic
	private String userName;
	
	@Column(name="contact_no")
	private long phoneNo;
	
	@Transient
	private String description;
	
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Embedded
	private Address address;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDob() {
		return dob;
	}
	public Gender getGender() {
		return gender;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	
}
