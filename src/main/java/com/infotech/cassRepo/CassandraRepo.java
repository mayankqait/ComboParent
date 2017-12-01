package com.infotech.cassRepo;

import java.util.List;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.infotech.entity.Employee;
import com.infotech.parent.Parenti;

@Repository
public interface CassandraRepo extends CassandraRepository<Employee>,Parenti{
	
	@Query(value="SELECT * FROM employee  WHERE id = ?0") 
	 public Employee findOne(int id);
	
	@Query(value="DELETE FROM employee  WHERE id = ?0") 
	 public void delete(int id);
	
	@Query(value="select * from employee  where name = ?0 ALLOW FILTERING")
	public List<Employee> findByName(@Param("name") String name);

	
}
