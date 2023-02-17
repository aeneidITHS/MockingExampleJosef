package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeManagerTest {
    EmployeeRepositoryStub employeeRepositoryStub = new EmployeeRepositoryStub( List.of(new Employee("1",1000),
                new Employee("2",2000),
                new Employee("3",3000),
                new Employee("4",4000)));
    EmployeeRepository employeeRepository = mock(EmployeeRepository.class);
    DummyBankService dummyBankService = new DummyBankService();
    Employee employee = mock(Employee.class);

    private final EmployeeManager employeeManager = new EmployeeManager(employeeRepositoryStub,dummyBankService);
    @Test
    void testIfPayEmployeesActuallyWorks() {

        int nrOfPayments = employeeManager.payEmployees();
        assertEquals(4,nrOfPayments);
    }
    @Test
    void testIfBankservicePayWorksAsIntended() {
        BankService bankService = mock(BankService.class);
        bankService.pay("1",1000);
        verify(bankService, Mockito.times(1)).pay("1",1000);

    }
}