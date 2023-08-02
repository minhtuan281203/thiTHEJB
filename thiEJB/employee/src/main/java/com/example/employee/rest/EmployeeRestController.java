package com.example.employee.rest;
import com.example.employee.dao.EmployeeRepository;
import com.example.employee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private final EmployeeRepository repository;

    @Autowired
    public EmployeeRestController(EmployeeRepository theEmployeeRepository){
        repository = theEmployeeRepository;
    }

    @GetMapping("/emp")
    List<Employee> all(){
        return repository.findAll();
    }
    @GetMapping("/emp/{id}")
    Employee one(@PathVariable Integer id){
        return repository.findById(id)
                .orElseThrow(()->new EmployeeNotFoundException(id));
    }
}
