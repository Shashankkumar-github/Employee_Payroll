package com.bridgelabz.Employee_Payroll.controller;

import com.bridgelabz.Employee_Payroll.dto.Employeedto;
import com.bridgelabz.Employee_Payroll.model.Employee;
import com.bridgelabz.Employee_Payroll.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
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
//    Logeer
    @PostMapping("/payroll/add")
    public String addPayroll(@RequestBody Employee record) {
        service.addPayrollRecord(record);
        log.info("Received request to add payroll record: {}", record);
        return "Payroll record added successfully!";
    }

    @GetMapping("/payroll/all")
    public List<Employee> getAllPayroll() {
        log.info("Received request to fetch all payroll records.");
        return service.getAllPayrollRecords();
    }

}

