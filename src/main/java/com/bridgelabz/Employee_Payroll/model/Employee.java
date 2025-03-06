package com.bridgelabz.Employee_Payroll.model;

import com.bridgelabz.Employee_Payroll.dto.Employeedto;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private double salary;
    public Employee(Employeedto employeeDTO) {
        this.name = employeeDTO.getName();
        this.salary = employeeDTO.getSalary();
    }

}

