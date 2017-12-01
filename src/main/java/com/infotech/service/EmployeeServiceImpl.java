package com.infotech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.repository.MapId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.infotech.cassRepo.CassandraRepo;
import com.infotech.entity.Employee;
//import com.infotech.jpaRepo.EmployeeRepository;
import com.infotech.parent.Parenti;

@Service 
public class EmployeeServiceImpl implements EmployeeService{
    
	
	/*@Autowired
    private EmployeeRepository employeeRepository;*/
	 
	/*@Autowired
	private CassandraRepo cassandraRepo;*/
	
	@Autowired
	private Parenti parent;
	 
	@Override
	public Employee getOne(int id) {
		//return employeeRepository.findOne(id);
		
		return parent.findOne(id);
	}

	@Override
	public List<Employee> getAll() {
		//return (List<Employee>)employeeRepository.findAll();
		
		return (List<Employee>)parent.findAll();
	}

	@Override
	public Employee saveEmp(Employee e) {
		//return employeeRepository.save(e);
		return parent.save(e);
	}

	public void delete(int id) {
         //employeeRepository.delete(id);
		parent.delete(id);
	}

	@Override
	public List<Employee> findByName(String name) {
		//return (List<Employee>) employeeRepository.findByName(name);
		
		return (List<Employee>)parent.findByName(name);
	}
    
	
}
