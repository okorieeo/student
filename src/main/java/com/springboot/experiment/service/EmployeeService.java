package com.springboot.experiment.service;

import com.springboot.experiment.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(long id);
    Employee getEmployeeByEmail(String email);
    Employee updateEmployee (Employee employee, long id);
    void deleteEmployee(long id);

}
