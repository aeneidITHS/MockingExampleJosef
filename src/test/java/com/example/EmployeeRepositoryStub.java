package com.example;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class EmployeeRepositoryStub implements EmployeeRepository {

    private List <Employee> employeesList;

    public EmployeeRepositoryStub(List<Employee> employee){
        this.employeesList = employee;
            }
    @Override
    public List<Employee> findAll() {
        return employeesList;
    }

    @Override
    public Employee save(Employee employee) {
        for (Employee e:
             employeesList) {
            if (employee.getId().equals(e.getId())){
                e = employee;
                return  employee;
            }
        }
        employeesList.add(employee);
        return employee;
    }
}
