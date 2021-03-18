package com.example.demo.service;

import com.example.demo.exception.NoUserFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService
{
    @Autowired
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployee()
    {
        return  employeeRepository.findAll();

    }
    public Employee createEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
       return employeeRepository.save(employee);
    }

    public Employee findById(Long id)
    {
        return  employeeRepository.findEmployeeById(id).orElseThrow(()->new NoUserFoundException("User with id "+id+"Nwas not foound"));

    }

    public void deleteEmpById(Long id)
    {
        employeeRepository.deleteById(id);
    }

    public Employee updateEmployee(Employee employee)
    {
        return employeeRepository.save(employee);
    }

}
