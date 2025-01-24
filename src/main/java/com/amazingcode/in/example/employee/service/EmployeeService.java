package com.amazingcode.in.example.employee.service;

import java.util.List;

import com.amazingcode.in.example.employee.entity.Employee;
import com.amazingcode.in.example.employee.external.response.UserResponse;

public interface EmployeeService {
    void createEmployee(Employee employee);
    void updateEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    void deleteEmployee(Long id);
    UserResponse getUsers();
}
