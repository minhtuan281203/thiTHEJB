package com.example.employee.service;
import  com.example.employee.dao.EmployeeRepository;
import com.example.employee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository)
    {
        employeeRepository = theEmployeeRepository;
    }
    @Override
    public List<Employee> findAll()
    {
        return employeeRepository.findAllOrderByNameAsc();
    }
    @Override
    public Employee findById(int theId)
    {
        Optional<Employee> results = employeeRepository.findById(theId);

        Employee theEmployee = null;
        if (results.isPresent())
        {
            theEmployee = results.get();
        }
        else {
            throw new RuntimeException("we did not find employee id" + theId);
        }
        return theEmployee;
    }
    @Override
    public List<Employee> searchBy(String theName)
    {
        List<Employee> results = null;
        if(theName != null &&(theName.trim().length()>0)){
            results = employeeRepository.findByNameContains(theName);
        }
        else {
            results = findAll();
        }
        return results;
    }
}
