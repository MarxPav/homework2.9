package ru.skypro.homework29;

public class Employee {
    private final String fullName;

    private int salary;

    private int department;

    private final int id;

    private static int counter;

    public Employee(String fullName, int salary, int department) {
        this.fullName = fullName;
        this.salary = salary;
        this.department = department;
        id = ++counter;
    }

    public String getFullName() {
        return fullName;
    }

    public int getSalary() {
        return salary;
    }

    public int getDepartment() {
        return department;
    }

    public int getId() {
        return id;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Employee employee = (Employee) object;
        return salary == employee.salary && department == employee.department && id == employee.id && java.util.Objects.equals(fullName, employee.fullName);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), fullName, salary, department, id);
    }

    @Override
    public java.lang.String toString() {
        return "Employee{" +
                "fullName=" + fullName +
                ", salary=" + salary +
                ", department=" + department +
                ", id=" + id +
                '}';
    }
}
