package com.chei.shop.service;

import com.chei.shop.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees(int pageNumber,int pageSize);
    Employee saveEmployee(Employee employee);
    Employee getSingleEmployee(Long id);
    void deleteEmployee(Long id);
    Employee updateEmployee(Employee employee);
    List<Employee> getEmployeesByName(String name);
    List<Employee> getEmployeesByNameAndLocation(String name, String location);
//    boolean updateEmployee(Employee employee,Long id);
List<Employee> getEmployeesByKeyword(String name);
List<Employee> getEmployeeByLocation(String location);
List<Employee> getEmployeesByNameOrLocation(String name,String location);
//List<Employee> getEmployeeNameAndAgeBetweenTwentyAndThirty(String name,int age);
}
