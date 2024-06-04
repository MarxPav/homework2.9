package ru.skypro.homework29.service;

import ru.skypro.homework29.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    Employee getEmployeeWithMinSalary(int department);

    Employee getEmployeeWithMaxSalary(int department);

    List<Employee> getAllEmployees(int department);

    Map<Integer, List<Employee>> getAllEmployeesDepartment();
}
