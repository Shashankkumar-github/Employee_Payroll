package com.bridgelabz.Employee_Payroll.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.bridgelabz.Employee_Payroll.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

