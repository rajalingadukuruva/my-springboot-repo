package com.example.service;

import com.example.dao.EmployeeRepository;
import com.example.model.Employee;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

	public Optional<Employee> findById(Integer employeeId) {
		// TODO Auto-generated method stub
		
	Optional<Employee> employee =employeeRepository.findById(employeeId);
	
		 
		 
		 return employee;
		
	}

	public Employee updateEmployee(Employee input) {
		
		
	Employee exsitingemp = employeeRepository.findById(input.getEmployeeId()).orElseThrow(()-> new RuntimeException("Employee not found"));
		
		exsitingemp.setEmpName(input.getEmpName());
		exsitingemp.setEmail(input.getAddress());

		
		Employee updateemp = employeeRepository.save(exsitingemp);
		return updateemp;
	}

	@Transactional
	public boolean deleteEmployee(int employeeId) {
		
		 if (employeeRepository.existsById(employeeId)) {
	            employeeRepository.deleteById(employeeId);
	            return true;
	        }
	        return false;		
	}

	 public Employee findByEmpName(String empName) {
	        return employeeRepository.findByEmpName(empName);
	    }
}
