package com.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeManagerIntergrationTest {
    DummyBankService bankService = new DummyBankService();
    EmployeeRepositoryStub employeeRepositoryStub = new EmployeeRepositoryStub( new ArrayList<>());
    EmployeeManager employeeManager =  new EmployeeManager(employeeRepositoryStub,bankService);
    @Test
    void payAllEmployees(){
        Employee employee1 = new Employee("1",1000);
        Employee employee2 = new Employee("2",2000);
        int nrOfPayment = employeeManager.payEmployees();
        assertEquals(2,nrOfPayment);
    }

}