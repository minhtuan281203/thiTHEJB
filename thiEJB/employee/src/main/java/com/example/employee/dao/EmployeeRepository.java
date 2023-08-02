package com.example.employee.dao;
import  com.example.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("SELECT e From Employee e order by e.name ASC")
    List<Employee> findAllOrderByNameAsc();

    List<Employee> findByNameContains(String name);
}
