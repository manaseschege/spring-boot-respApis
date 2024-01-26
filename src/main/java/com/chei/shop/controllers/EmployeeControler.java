package com.chei.shop.controllers;

import com.chei.shop.model.Employee;
import com.chei.shop.service.EmployeeService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class EmployeeControler {
    @Autowired
    EmployeeService eService;


    @GetMapping(value = "/employee")
    public ResponseEntity<List<Employee>> getData(@RequestParam int pageNumber,@RequestParam int pageSize){

        return new ResponseEntity<List<Employee>>(eService.getEmployees(pageNumber,pageSize), HttpStatus.OK);
    }
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long id){
        return new ResponseEntity<>(eService.getSingleEmployee(id), HttpStatus.OK);
    }
    @PostMapping("/employee")
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee){
        return new ResponseEntity<>(eService.saveEmployee(employee),HttpStatus.CREATED);
    }

    @DeleteMapping("/employee")
    public ResponseEntity<HttpStatus> deleteEmployee(@RequestParam("id") Long id){


        return  new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee employee){
          employee.setId(id);
              return new ResponseEntity<>(eService.updateEmployee(employee), HttpStatus.OK);
    }
    @GetMapping("/employees/filterByName")
    public ResponseEntity<List<Employee>> getEmployeesByName(@RequestParam String name){
return new ResponseEntity<List<Employee>>(eService.getEmployeesByName(name),HttpStatus.OK);
    }
    @GetMapping("/employees/filterByNameAndLocation")
    public ResponseEntity<List<Employee>> getEmployeesByNameAndLocation(@RequestParam String name, @RequestParam String location){
        return  new ResponseEntity<List<Employee>>(eService.getEmployeesByNameAndLocation(name,location),HttpStatus.OK);
    }
    @GetMapping("/employees/filterByKeyword")
    public ResponseEntity<List<Employee>> getEmployeesByKeyword(@RequestParam String name){
        return new ResponseEntity<List<Employee>>(eService.getEmployeesByKeyword(name),HttpStatus.OK);
    }
    @GetMapping("/employees/filterByLocation")
    public ResponseEntity<List<Employee>> getEmployeeByLocation(@RequestParam String location){
        return new ResponseEntity<List<Employee>>(eService.getEmployeeByLocation(location),HttpStatus.OK);
    }
//@GetMapping("/employees/filterByNameAndAge")
//    public ResponseEntity<List<Employee>> getEmployeeNameAndAgeBetweenTwentyAndThirty(@RequestParam String name, @RequestParam int age){
//        return new ResponseEntity<List<Employee>>(eService.getEmployeeNameAndAgeBetweenTwentyAndThirty(name,age),HttpStatus.OK);
//    }
@GetMapping("/employees/filterByNameOrLocation")
public ResponseEntity<List<Employee>> getEmployeeByNameOrLocation(@PathVariable String name,@PathVariable String location){
    return new ResponseEntity<List<Employee>>(eService.getEmployeesByNameOrLocation(name,location),HttpStatus.OK);
}
}
