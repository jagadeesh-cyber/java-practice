package com.infy.db;

import com.infy.entities.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeDatabase {
    public static List<Employee> getEmployeeDetails() {
        List<Employee> employeeList;
        Employee employee1 = new Employee(1, "Pushpa", 23, 90000,"active");
        Employee employee2 = new Employee(2, "Jagadeesh", 26, 60000,"active");
        Employee employee3 = new Employee(3, "Sandhya", 30, 70000,"inactive");
        Employee employee4 = new Employee(4, "Lavanya", 31, 80000,"active");

        employeeList = Arrays.asList(employee1, employee2, employee3, employee4);
        return employeeList;
    }
}
