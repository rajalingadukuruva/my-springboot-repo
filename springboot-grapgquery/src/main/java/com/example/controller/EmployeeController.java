package com.example.controller;

import com.example.model.Employee;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @MutationMapping(name = "createEmployee")
    public Employee createEmployee(@Argument("input") Employee input) {
        return employeeService.createEmployee(input);
    }

    @QueryMapping(name = "findAllEmployees")
    public List<Employee> findAllEmployees() {
        return employeeService.findAllEmployees();
    }
    
    
    @QueryMapping(name = "findEmployeeById")
    public Optional<Employee> findEmployeeById(@Argument("employeeId")int employeeId) {
    	
    Optional<Employee> emp=employeeService.findById(employeeId);
	return emp;
    }
    
    @QueryMapping
    public Employee findByEmpName(@Argument("empName") String empName) {
        return employeeService.findByEmpName(empName);
    }
    
    @MutationMapping(name = "updateEmployee")
    public Employee updateEmployee(@Argument("input")Employee input) {
    	
    Employee emp=employeeService.updateEmployee(input);
    
    return emp;
    	
    }
    
    @MutationMapping(name ="deleteEmployee" )
    public boolean deleteEmployee(@Argument("employeeId")int employeeId) {
    	
    boolean employee=employeeService.deleteEmployee(employeeId);
    
    return employee;
    	
    }
    
}
