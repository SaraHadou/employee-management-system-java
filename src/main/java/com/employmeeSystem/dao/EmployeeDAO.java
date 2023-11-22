package com.employmeeSystem.dao;

import com.employmeeSystem.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    void save(Employee theEmployee);
    Employee findById(int id);
    List<Employee> findAll();
    List<Employee> findByDepartment(String theDepartment);
    List<Employee> findByPosition(String thePosition);
    List<Employee> findByFirstName(String theFirstName);
    void update(Employee theEmployee);
    void delete(int id);
    int deleteAll();
}

