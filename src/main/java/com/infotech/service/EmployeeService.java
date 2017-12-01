package com.infotech.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.infotech.entity.Employee;

public interface EmployeeService {
    
	public Employee getOne(int id);
	public List<Employee> getAll();
	public Employee saveEmp(Employee e);
	public void delete(int id);
	public List<Employee> findByName(String name);
}
