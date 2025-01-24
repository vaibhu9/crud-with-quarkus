package com.amazingcode.in.example.employee.repository;

import com.amazingcode.in.example.employee.entity.Employee;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

public interface EmployeeRepository extends PanacheRepository<Employee> {
    
}
