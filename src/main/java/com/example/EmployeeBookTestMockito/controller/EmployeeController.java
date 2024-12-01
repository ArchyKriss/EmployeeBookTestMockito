package com.example.EmployeeBookTestMockito.controller;

import com.example.EmployeeBookTestMockito.Employee;
import com.example.EmployeeBookTestMockito.servise.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
@RequestMapping("employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("add")
    public Employee add(
            @RequestParam ("firstName") String firstName,
            @RequestParam ("lastName") String lastName,
    ){      @RequestParam ("salary") int salary,
            @RequestParam ("departmentId") int departmentId;
        return employeeService.add(firstName, lastName, salary, departmentId);
    }
    @GetMapping("remove")
    public Employee remove(
            @RequestParam ("firstName") String firstName,
            @RequestParam ("lastName") String lastName
    ) {
        return employeeService.remove(firstName, lastName);
    }
    @GetMapping("find")
    public Employee find(
            @RequestParam ("firstName") String firstName,
            @RequestParam ("lastName") String lastName
    ) {
        return employeeService.find(firstName, lastName);
    }
    @GetMapping
    public Map<String, Employee> getAll(){
        return employeeService.getAll;
    }


}
