package ru.skypro.homework29.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import ru.skypro.homework29.Employee;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private Map<String, Employee> employees = new HashMap<>();

    @PostConstruct
    public void init() {
        employees.put("Павел Петрович", new Employee("Павел Петрович ", 80_300, 1));
        employees.put("Сергей Егорович", new Employee("Сергей Егорович ", 95_800, 2));
        employees.put("Анастасия Семёнова", new Employee("Анастасия Семёновна ", 55_550, 4));
        employees.put("Мария Дмитриевна", new Employee("Мария Дмитриевна ", 65_000, 4));
        employees.put("Пётр Анатольевич", new Employee("Пётр Анатольевич", 97_000, 2));
        employees.put("Алексей Петрович", new Employee("Алексей Петрович", 38_000, 3));
        employees.put("Сергей Станиславович", new Employee("Сергей Станиславович", 33_000, 3));
        employees.put("Регина Баджуханяновна", new Employee("Регина Баджуханяновна", 35_000, 3));
        employees.put("Исмаил Иргануинович", new Employee("Исмаил Иргануинович", 50_800, 6));
        employees.put("Елена Анатольевна", new Employee("Елена Анатольевна", 43_550, 5));
    }
    @Override
    public Employee getEmployeeWithMinSalary(int department) {
        return employees.values().stream().filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public Employee getEmployeeWithMaxSalary(int department) {
        return employees.values().stream().filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public List<Employee> getAllEmployees(int department) {
        return employees.values()
                .stream().filter(employee -> employee.getDepartment() == department)
                .toList();
    }

    @Override
    public Map<Integer, List<Employee>> getAllEmployeesDepartment() {
        return employees.values().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
