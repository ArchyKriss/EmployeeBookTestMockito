package com.example.EmployeeBookTestMockito.exception;

public class EmployeeStorageIsFullException extends RuntimeException {
    public EmployeeStorageIsFullException(String message) {

        super(message);
    }
}
