package com.bridgelabz.Employee_Payroll.controller;

import com.bridgelabz.Employee_Payroll.dto.Employeedto;
import com.bridgelabz.Employee_Payroll.model.Employee;
import com.bridgelabz.Employee_Payroll.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin("*") // Allow frontend requests
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return service.getEmployeeById(id);
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employeedto employeedto) {
        return service.addEmployee(employeedto);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employeedto employeedto) {
        return service.updateEmployee(id, employeedto);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        service.deleteEmployee(id);
        return "Employee deleted succesfully";
    }

}

