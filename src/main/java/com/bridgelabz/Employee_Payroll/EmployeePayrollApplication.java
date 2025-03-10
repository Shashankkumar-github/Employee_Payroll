package com.bridgelabz.Employee_Payroll;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
@SpringBootApplication
public class EmployeePayrollApplication {

	public static void main(String[] args) {


		ConfigurableApplicationContext context = SpringApplication.run(EmployeePayrollApplication.class, args);
		log.info("EmployeePayroll App Started in {} Environment", context.getEnvironment().getProperty("environment"));
	}
}
