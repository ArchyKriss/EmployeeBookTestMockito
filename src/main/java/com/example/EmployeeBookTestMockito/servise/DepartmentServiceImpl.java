package com.example.EmployeeBookTestMockito.servise;

import com.example.EmployeeBookTestMockito.Employee;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @Override
    public int getEmployeeSalarySum(int departmentId) {
        return employeeService.getAll()
                .values()
                .stream()
                .mapToInt(Employee::getSalary)
                .sum();
    }

    @Override
    public Employee getEmployeeWithMaxSalary(int departmentId) {
        return employeeService.getAll()
                .values()
                .stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public Employee getEmployeeWithMinSalary(int departmentId) {
        return employeeService.getAll()
                .values()
                .stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public List<Employee> getAllEmployeesByDepartmentId(int departmentId) {
        return employeeService.getAll()
                .values()
                .stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .toList();
    }

    @Override
    public Map<Integer, List<Employee>> getAllEmployeesGroupedByDepartmentId(int departmentId) {
        return employeeService.getAll()
                .values()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
