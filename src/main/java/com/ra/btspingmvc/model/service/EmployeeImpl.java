package com.ra.btspingmvc.model.service;

import com.ra.btspingmvc.model.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeImpl implements IEmployee {
    private static final List<Employee> employeeList = new ArrayList<>();


    @Override
    public List<Employee> findAll() {
        employeeList.add(new Employee(1, "Quỳnh Anh", "tn", "0912999998", true));
        employeeList.add(new Employee(2, "Quỳnh Mai", "tn", "0913999999", true));
        employeeList.add(new Employee(3, "Anh CM", "hn", "0912999997", true));
        employeeList.add(new Employee(4, "KOKOKO", "tn", "0912999996", true));
        employeeList.add(new Employee(5, "Đi Ké", "hn", "0912999995", true));
        return employeeList;
    }

    @Override
    public Employee findById(Integer id) {
        return employeeList.stream().filter(employee -> employee.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public void save(Employee employee) {
        Integer id = employeeList.stream().map(Employee::getId).max(Integer::compareTo).orElse(0) + 1;
        employee.setId(id);
        employeeList.add(employee);
    }

    @Override
    public void update(Employee employee) {
        employeeList.set(employeeList.indexOf(employeeList.
                stream().
                filter(employee1 -> employee1.getId().equals(employee.getId())).
                findFirst().orElse(null)), employee);
    }

    @Override
    public void delete(Integer id) {
        employeeList.remove(findById(id));
    }
}
