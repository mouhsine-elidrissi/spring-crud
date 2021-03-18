package com.example.demo;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/")
public class WelcomeController
{
    @Autowired
    private final EmployeeService employeeService;

    public WelcomeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>>   welcome(){
        List employees= employeeService.getAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> ajouteEmployee( @RequestBody  Employee employee)
    {
        Employee newEmployee = employeeService.createEmployee(employee);
        return new ResponseEntity<>(newEmployee,HttpStatus.CREATED) ;
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<Employee>  findEmpById(@PathVariable("id") Long id){
        Employee employee= employeeService.findById(id);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee( @PathVariable("id") Long id)
    {
        employeeService.deleteEmpById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> upToDateEmployee( @RequestBody  Employee employee)
    {
        Employee updateEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee,HttpStatus.OK) ;
    }






}
