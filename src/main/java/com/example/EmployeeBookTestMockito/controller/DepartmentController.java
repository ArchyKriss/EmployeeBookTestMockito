package com.example.EmployeeBookTestMockito.controller;

import com.example.EmployeeBookTestMockito.Employee;
import com.example.EmployeeBookTestMockito.servise.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping("{departmentId}/employees")
    public List<Employee> getAllEmployeesByDepartmentId(@PathVariable int departmentId){
        return departmentService.getAllEmployeesByDepartmentId(departmentId);
    }

    @GetMapping("{departmentId}/salary/sum")
    public int Employee getEmployeeSalarySum(@PathVariable int departmentId){
        return departmentService.getEmployeeSalarySum(departmentId);
    }

    @GetMapping("{departmentId}/salary/max")
    public Employee getEmployeeWithMaxSalary(@PathVariable int departmentId){
        return departmentService.getEmployeeWithMaxSalary(departmentId);
    }

    @GetMapping("{departmentId}/salary/min")
    public Employee getEmployeeWithMinSalary(@PathVariable int departmentId){
        return departmentService.getEmployeeWithMinSalary(departmentId);
    }

    @GetMapping("employees")
    public Map<Integer, List<Employee>> getAllEmployeesGroupedByDepartmentId(){
        return departmentService.getAllEmployeesGroupedByDepartmentId();
    }
}
