package com.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeRepositoryStubInMemoryTest {
    EmployeeRepositoryStub employeeRepositoryStub = new EmployeeRepositoryStub( List.of(new Employee("1",1000),
            new Employee("2",2000),
            new Employee("3",3000),
            new Employee("4",4000)));
    EmployeeRepositoryStub employeeRepositoryStubWithoutEmployees = new EmployeeRepositoryStub(new ArrayList<>());

    @Test
     void findAllTest(){
        List<Employee> employees =  employeeRepositoryStub.findAll();
        assertEquals(4,employees.size());
    }
    @Test
    void saveShouldChangeEmployee(){
        Employee employee1 = new Employee("1",1000);
        Employee employee2 = new Employee("2",2000);
        Employee employee3 = new Employee("1", 3000);
        employeeRepositoryStubWithoutEmployees.save(employee1);
        employeeRepositoryStubWithoutEmployees.save(employee2);
        employeeRepositoryStubWithoutEmployees.save(employee3);
        List<Employee> employees = employeeRepositoryStubWithoutEmployees.findAll();
        assertEquals(2,employees.size());


    }




}