package com.chei.shop.repository;

import com.chei.shop.model.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
List<Employee> findByName(String name);
List<Employee> findByNameAndLocation(String name, String location);
List<Employee>findByNameContaining(String keyword, Sort sort);
List<Employee>findByLocation(String location);
//List<Employee>findByNameAndAgeBetweenTwentyAndThrirty(String name, int age);
@Query("FROM Employee WHERE name = :name OR  location = :location")
List<Employee> findByNameOrLocation(String name, String location);


}
