package com.amazingcode.in.example.employee.service.impl;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.amazingcode.in.example.employee.entity.Employee;
import com.amazingcode.in.example.employee.external.client.UserServiceClient;
import com.amazingcode.in.example.employee.external.response.UserResponse;
import com.amazingcode.in.example.employee.repository.EmployeeRepository;
import com.amazingcode.in.example.employee.service.EmployeeService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Inject
    @RestClient
    private UserServiceClient userServiceClient;

    @Inject
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    @Transactional
    public void createEmployee(Employee employee) {
        employeeRepository.persist(employee);
    }
    
    @Override
    @Transactional
    public void updateEmployee(Employee employee) {
        employeeRepository.getEntityManager().merge(employee);
    }

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeRepository.listAll();
    }

    @Override
    @Transactional
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id); 
    }

    @Override
    @Transactional
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public UserResponse getUsers() {
        return userServiceClient.getUsers();
    }
}
