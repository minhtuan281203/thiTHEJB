package com.example.employee.rest;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(Integer id) {
        super("Khong tim thay id: " + id);
    }
}
