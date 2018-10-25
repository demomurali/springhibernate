package com.demo.springhibernatedemo.entity;

import java.util.*;

import javax.persistence.*;

import com.demo.springhibernatedemo.dao.Employee;

@Entity
@Table(name="dep123456")
public class Department {

	@Id
	private int departmentId;
	private String location;
	private String name;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="departmentId")
	private Set<Employee> employees=new HashSet<Employee>();
	
	public Department(int  departmentId,String location,String name){
		this.departmentId=departmentId;
		this.location=location;
		this.name=name;
	}
	
	public Department(){
	}
	
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public Set<Employee> getEmployees() {
		return employees;
	}


	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

}

