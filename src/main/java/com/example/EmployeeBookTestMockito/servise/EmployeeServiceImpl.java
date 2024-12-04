package com.example.EmployeeBookTestMockito.servise;

import com.example.EmployeeBookTestMockito.Employee;
import com.example.EmployeeBookTestMockito.exception.EmployeeAlreadyAddedException;
import com.example.EmployeeBookTestMockito.exception.EmployeeNotFoundException;
import com.example.EmployeeBookTestMockito.exception.EmployeeStorageIsFullException;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    public static final int STORAGE_SIZE = 7;

    private final Map<String, Employee> employees = new HashMap<>();

    @PostConstruct
    public void initEmployees(){
        add("Ivan", "Petrov", 100000, 1);
        add("Dmitriy", "Smirnov", 120000, 2);
        add("Oleg", "Leonov", 130000, 3);
        add("Semen", "Komarov", 140000, 1);
        add("Maxim", "Ivanov", 150000, 2);
        add("Aleksandr", "Sergeev", 160000, 3);
        add("Konstantin", "Kozlov", 170000, 2);
    }

    @Override
    public Employee add(String firstName, String lastName, int salary, int departmentId) {
        if (employees.size() >= STORAGE_SIZE) {
            throw new EmployeeStorageIsFullException("Хранилище переполнено");
        }
        if (employees.containsKey(getKey(firstName, lastName))) {
            throw new EmployeeAlreadyAddedException("Сотрудник с именем" + firstName + "и фамилией" + lastName + "уже находится в списке");
        }

        Employee employee = new Employee(firstName, lastName, salary, departmentId);
        employee.put(getKey(employee), employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName){
        if(employees.containsKey(getKey(firstName, lastName))){
            throw new EmployeeNotFoundException("Сотрудник с именем" + firstName + "и фамилией" + lastName + "не найден");
        }
        return employees.remove(getKey(firstName, lastName));
    }

    @Override
    public Employee find(String firstName, String lastName){
        Employee employee = employees.get(getKey(firstName, lastName));
        if(employee==null){
            throw new EmployeeNotFoundException("Сотрудник с именем" + firstName + "и фамилией" + lastName + "не найден");
        }
        return employee;
    }

    @Override
    public Map<String, Employee> getAll() {
        return Collections.unmodifiableMap(employees);
    }

    private static String getKey (String firstName, String lastName){
        return firstName + lastName;
    }
    private static String getKey(Employee employee){
        return employee.getFirstName() + employee.getLastName();
    }


}
