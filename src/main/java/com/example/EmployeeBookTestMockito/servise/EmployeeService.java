package com.example.EmployeeBookTestMockito.servise;

import com.example.EmployeeBookTestMockito.Employee;

import java.util.Map;

public interface EmployeeService {

    Employee add(String firstName, String lastName, int salary, int departmentId);

    Employee remove(String firstName, String lastName);

    Employee find(String firstName, String lastName);

    Map<String, Employee> getAll();

    void remove(int id);

    Employee findById(int id);
}
