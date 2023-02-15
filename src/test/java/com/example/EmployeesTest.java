package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class EmployeesTest {
    EmployeeRepositoryStub employeeRepositoryStub = new EmployeeRepositoryStub();
    DummyBankService bankService = new DummyBankService();
    private final Employees employees = new Employees(employeeRepositoryStub,bankService);
    @Test
    void testIfPayEmployeesActuallyWorks() {
        int nrOfPayments = employees.payEmployees();
        assertEquals(2,nrOfPayments);
    }
    @Test
    void testIfFindAllReturnsAnything() {
        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);
        assertNotSame(employeeRepositoryStub.findAll(),employeeRepository.findAll());
    }
}