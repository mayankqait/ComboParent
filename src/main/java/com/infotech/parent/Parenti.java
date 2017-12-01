package com.infotech.parent;

import java.util.List;


import com.infotech.entity.Employee;

public interface Parenti {
	public Employee findOne(int id);
	public List<Employee> findByName(String name);
	public void delete(int id);
	public List<Employee> findAll();
	public Employee save(Employee e);
}
