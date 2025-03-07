package com.bridgelabz.Employee_Payroll.service;

import com.bridgelabz.Employee_Payroll.model.Employee;
import com.bridgelabz.Employee_Payroll.dto.Employeedto;
import com.bridgelabz.Employee_Payroll.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    private final List<Employee> payrollData = new ArrayList<>();

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Employee addEmployee(Employeedto employeedto) {
        Employee employee = new Employee(employeedto);
        return repository.save(employee);
    }

    public Employee updateEmployee(Long id, Employeedto employeedto) {
       Optional<Employee> existingEmployee = Optional.ofNullable(repository.findById(id).orElse(null));
        if (existingEmployee.isPresent()) {
            Employee employee =existingEmployee.get();
            employee.setName(employee.getName());
            employee.setEmail(employee.getEmail());
            employee.setSalary(employee.getSalary());
            return repository.save(employee);
        }
        else {
            throw new RuntimeException("Employee not found ");
        }
    }

    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }


}
