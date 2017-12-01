package com.infotech.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infotech.entity.Employee;
import com.infotech.service.EmployeeServiceImpl;

@RestController
@RequestMapping(value="/todo")
public class MainController  {
 
    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;
    
 
    
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Employee getEmployee(@PathVariable("id") Integer id)throws IllegalArgumentException {
    	return employeeServiceImpl.getOne(id);
    }    
    @GetMapping(path="/")
    public List<Employee> getAllEmployee(){
    	return (List<Employee>) employeeServiceImpl.getAll();
    }
    
    @PostMapping(path="/add")
    public ResponseEntity addEmployee(@RequestBody Employee e){
    	 employeeServiceImpl.saveEmp(e);
    	return new ResponseEntity(e, HttpStatus.OK);
    }
    
   
	@GetMapping(path="/getByName/{name}")
    public List<Employee> getByName(@PathVariable("name") String name) {
    	return (List<Employee>)employeeServiceImpl.findByName(name);
    }
	
	@DeleteMapping(path="/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		employeeServiceImpl.delete(id);
		return "Employee with id = "+id+" is deleted.";
	}
	
	/*@PutMapping(path="/update/{id}")
	public String update(@RequestBody Employee e,@PathVariable("id") Integer id) {
		Employee oldData=(Employee)employeeRepository.findOne(id);
		if(oldData!=null) {
			oldData.setName(e.getName());
			oldData.setSalary(e.getSalary());
			oldData.setCompany(e.getCompany());
			employeeRepository.save(e);
			return oldData.toString();
		}
		else {
			return "User does not esist.";
		}
	}*/
	
	/*@GetMapping(path="/getTaskOfEmployeeByName/{name}")
	public Set<Object> getTaskOfEmployeeByName(@PathVariable("name") String name) {
		List<Employee> e=employeeRepository.findByName(name);
		Set<Object> list= new HashSet<Object>();
		
		for(Employee emp:e) {
		System.out.println("Task=== "+emp.getTaskList());
		//list.add((Task)emp.getTaskList());
			 list.add(emp.getTaskList());
		}
		return list;
	}*/
	
    /*@GetMapping(path="/getSalaryGreaterThan/{salary}")
	public List<Employee> getSalaryGreaterThan(@PathVariable("salary") Integer salary) {
    	List<Employee> emp=(List<Employee>)employeeRepository.findBySalaryGreaterThan(salary);
    	return emp;
    }*/
    
    
	
	
}