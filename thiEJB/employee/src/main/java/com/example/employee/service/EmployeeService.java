package com.example.employee.service;
import com.example.employee.entity.Employee;
import java.util.List;
public interface EmployeeService  {
    public List<Employee> findAll();
    public Employee findById(int theId);
    public List<Employee> searchBy(String theName);
}
