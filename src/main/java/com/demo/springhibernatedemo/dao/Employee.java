package com.demo.springhibernatedemo.dao;

import javax.persistence.*;

import com.demo.springhibernatedemo.entity.Department;

@Entity
@Table(name="emp123455")
public class Employee {
	@Id
	private int employeeId;
	private String staffName;
	private String specialization;

	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "department_Id")
	private Department departmentId;
	
	public Employee(String staffName,int employeeId,String specialization) {
		this.staffName=staffName;
		this.employeeId=employeeId;
		this.specialization=specialization;
	}

	public Employee(){
	}
	public String getStaffName() {
		return staffName;
	}


	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public int getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}


	public String getSpecialization() {
		return specialization;
	}


	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public Department getDepartment() {
		return departmentId;
	}

	public void setDepartment(Department department) {
		this.departmentId = department;
	}

}



