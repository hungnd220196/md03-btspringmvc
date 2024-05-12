package com.ra.btspingmvc.model.service;

import com.ra.btspingmvc.model.entity.Employee;

import java.util.List;

public interface IEmployee {
    List<Employee> findAll() ;
    Employee findById(Integer id) ;
    void save(Employee employee);
    void update(Employee employee) ;
    void delete(Integer id);
}
