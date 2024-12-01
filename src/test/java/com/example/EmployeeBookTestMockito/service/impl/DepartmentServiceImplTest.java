package com.example.EmployeeBookTestMockito.service.impl;

import com.example.EmployeeBookTestMockito.Employee;
import com.example.EmployeeBookTestMockito.servise.DepartmentServiceImpl;
import com.example.EmployeeBookTestMockito.servise.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

@ExtendWith(MockitoExtension.class)

public class DepartmentServiceImplTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    private final Map<String, Employee> employees = new HashMap<>(){{
        put("Ivan1Petrov1", new Employee("Ivan1", "Petrov1", 100000, 1));
        put("Ivan2Petrov2", new Employee("Ivan2", "Petrov2", 120000, 1));
        put("Ivan3Petrov3", new Employee("Ivan3", "Petrov3", 130000, 1));
    }};

    @Test
    public void shouldCorrectlyCalculateSalarySum(){
        int departmentId = 1;
        int expectedSum = 600000;

        Mockito.when(employeeService.getAll()).thenReturn(employees);

        int actualSum = departmentService.getEmployeeSalarySum(departmentId);

        Assertions.assertEquals(expectedSum, actualSum);

    }

@Test
public void shouldCorrectlyFindEmployeeWithMinSalary() {

    int departmentId = 1;

    Employee expectedEmployee = employees.get("Ivan1Petrov1");

    Mockito.when(employeeService.getAll()).thenReturn(employees);

    Employee actualEmployee = departmentService.getEmployeeWithMinSalary(departmentId);

    Assertions.assertEquals(expectedEmployee, actualEmployee);
}
@Test
public void shouldCorrectlyFindEmployeeWithMaxSalary(){

    int departmentId = 1;

    Employee expectedEmployee = employees.get("Ivan3Petrov3");

    Mockito.when(employeeService.getAll()).thenReturn(employees);

    Employee actualEmployees = departmentService.getEmployeeWithMaxSalary(departmentId);

    Assertions.assertEquals(expectedEmployee, actualEmployees);
}
    @Test
    public void shouldCorrectlyFindEmployeeByDepartmentId() {

        int departmentId = 1;

        Collection<Employee> expectedEmployee = new ArrayList<>(employees.values());

        Mockito.when(employeeService.getAll()).thenReturn(employees);

        List<Employee> actualEmployee = departmentService.getAllEmployeesByDepartmentId(departmentId);

        Assertions.assertEquals(expectedEmployee, actualEmployee);
    }

    @Test
    public void shouldCorrectlyGroupEmployeesByDepartmentId(){

        Map<Integer, List<Employee>> expectedEmployees = new HashMap<>() {{
            put(1, new ArrayList<>(employees.values()));
        }};

        Mockito.when(employeeService.getAll()).thenReturn(employees);

       Map<Integer, List<Employee>> actualEmployee = departmentService.getAllEmployeesGroupedByDepartmentId();

       Assertions.assertEquals(expectedEmployees, actualEmployee);

    }
}