package com.amazingcode.in.example.employee.controller;

import java.util.List;

import com.amazingcode.in.example.employee.entity.Employee;
import com.amazingcode.in.example.employee.external.response.UserResponse;
import com.amazingcode.in.example.employee.service.EmployeeService;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/employees")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeController {

    private final EmployeeService employeeService;

    @Inject
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @POST
    public Response createEmployee(Employee employee) {
        employeeService.createEmployee(employee);
        return Response.status(Response.Status.CREATED).entity(employee).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateEmployee(@PathParam("id") Long id, Employee toUpdateEmployee) {
        Employee existingEmployee = employeeService.getEmployeeById(id);
        if (existingEmployee == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        toUpdateEmployee.setId(id);
        employeeService.updateEmployee(toUpdateEmployee);
        return Response.ok(toUpdateEmployee).build();
    }

    @GET
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GET
    @Path("/{id}")
    public Response getEmployeeById(@PathParam("id") Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(employee).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteEmployee(@PathParam("id") Long id) {
        employeeService.deleteEmployee(id);
        return Response.noContent().build();
    }

    @GET
    @Path("/users")
    public Response getUsers() {
        UserResponse users = employeeService.getUsers();
        return Response.ok(users).build();
    }
}
