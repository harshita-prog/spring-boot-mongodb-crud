package com.demo.repository;

import java.util.List;

import com.demo.model.Employee;

public interface EmployeeQueryDao {
	
	List<Employee> getAll();

	List<Employee> getEmployeeByFirstName(String firstName);

	Employee getSingleEmployeeByFirstName(String firstName);

	List<Employee> getEmployeeByFirstNameLike(String firstName);

	Employee getSingleEmployeeByLastName(String lastName);

	List<Employee> getEmployeeBySalaryGreaterThan(int salary);

}
