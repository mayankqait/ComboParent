package com.infotech.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.Transient;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table
@EntityListeners(AuditingEntityListener.class)
public class Employee implements Serializable{
	
	
    @Id
    @PrimaryKey
	private int Id;
    @Column(name="Name")
	private String Name;
    @Column(name="Salary")
	private int Salary;
    @Column(name="Company")
	private String Company;
    
    @Transient
    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY,mappedBy="taskId")
	private Set<Task> taskList=new HashSet<>();
	
	public Employee(int id, String name, int salary, String company) {
		super();
		Id = id;
		Name = name;
		Salary = salary;
		Company = company;
	}

	public Employee() {
		super();
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return Id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		Id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		Name = name;
	}

	/**
	 * @return the salary
	 */
	public int getSalary() {
		return Salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(int salary) {
		Salary = salary;
	}

	/**
	 * @return the company
	 */
	public String getCompany() {
		return Company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		Company = company;
	}
	
	

	

	public Set<Task> getTaskList() {
		return taskList;
	}

	public void setTaskList(Set<Task> taskList) {
		this.taskList = taskList;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee [Id=" + Id + ", Name=" + Name + ", Salary=" + Salary + ", Company=" + Company + "]";
	}
	
	
}
