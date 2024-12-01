package com.example.EmployeeBookTestMockito.service.impl;

import com.example.EmployeeBookTestMockito.Employee;
import com.example.EmployeeBookTestMockito.exception.EmployeeStorageIsFullException;
import com.example.EmployeeBookTestMockito.servise.EmployeeServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.example.EmployeeBookTestMockito.servise.EmployeeServiceImpl.STORAGE_SIZE;

public class EmployeeServiceImplTest {

    private EmployeeServiceImpl employeeService;

    @BeforeEach
    public void clear(){
        employeeService = new EmployeeServiceImpl();
    }

    @Test
    public void shouldCorrectlyAddNewEmployee(){

        Employee employeeToAdd = new Employee("Ivan", "Ivanov", 30000, 2);

        Employee addedEmployee = employeeService.add(
                employeeToAdd.getFirstName(),
                employeeToAdd.getLastName(),
                employeeToAdd.getSalary(),
                employeeToAdd.getDepartment());

        Assertions.assertEquals(employeeToAdd, addedEmployee);

    }
    @Test
    public void shouldCorrectlyRemoveNewEmployee(){

        Employee employeeToRemove = new Employee("Ivan", "Ivanov", 30000, 2);

        Employee addedEmployee = employeeService.add(
                employeeToRemove.getFirstName(),
                employeeToRemove.getLastName(),
                employeeToRemove.getSalary(),
                employeeToRemove.getDepartment());

        Assertions.assertEquals(employeeToRemove, addedEmployee);

    }

    @Test
    public void shouldCorrectlyFindNewEmployee(){

        Employee employeeToFind = new Employee("Ivan", "Ivanov", 30000, 2);

        Employee addedEmployee = employeeService.add(
                employeeToFind.getFirstName(),
                employeeToFind.getLastName(),
                employeeToFind.getSalary(),
                employeeToFind.getDepartment());

        Assertions.assertEquals(employeeToFind, addedEmployee);

    }

    @Test
    public void shouldThrowEmployeeAlreadyAddedExceptionWhenStorageIsFull(){

        for (int i = 0; i < STORAGE_SIZE; i++) {
            employeeService.add("Ivan" + i, "Ivanov", 30000, 1);
        }
        Assertions.assertThrows(
                EmployeeStorageIsFullException.class,
                () ->
                        employeeService.add("Ivan", "Ivanov", 30000, 1));
    }
    }

