package com.infotech.jpaRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.infotech.entity.Employee;
import com.infotech.parent.Parenti;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> ,Parenti{

	public Employee findOne(Integer id);
	public void delete(int id);
	
	@Query(value="select * from employee e where e.name = :name",nativeQuery = true)
	public List<Employee> findByName(@Param("name") String name);
	
	@Query(value="select * from employee e where e.salary > :salary",nativeQuery=true)	
	public List<Employee> findBySalaryGreaterThan(@Param("salary") int salary);
	
}
