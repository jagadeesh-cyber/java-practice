package com.infy.streams;

import com.infy.db.EmployeeDatabase;
import com.infy.entities.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsExample {
    public static List<Employee> employees= EmployeeDatabase.getEmployeeDetails();

    public static void employeeOperations(){

        employees.stream()
                .sorted(Comparator.comparing(Employee::getEmpSalary).reversed())
                .findFirst()
                .map(Employee::getEmpName)
                .ifPresent(System.out::println);
        Optional<Employee> collect = employees.stream()
                .max(Comparator.comparing(Employee::getEmpSalary));
        collect.ifPresent(val-> System.out.println(val.getEmpName()));
        System.out.println("--------------------------------------------------------------");
        System.out.println("Employee status details count");
        Map<String, Long> empstatus=employees.stream()
                .collect(Collectors.groupingBy(Employee::getEmpStatus,Collectors.counting()));
        empstatus.entrySet().stream().forEach(dt->{
            System.out.println(dt.getKey()+"    "+dt.getValue());
            System.out.println("-----------------------------------------------------");
           Map<String,Optional<Employee>> maxem= employees.stream()
                    .collect(Collectors.groupingBy(Employee::getEmpStatus,Collectors.maxBy(Comparator.comparing(Employee::getEmpSalary))));
            for (Map.Entry<String, Optional<Employee>> dat:
                 maxem.entrySet()) {
                Employee employee=dat.getValue().isPresent()?dat.getValue().get():new Employee();
                System.out.println("status "+dat.getKey()+" max salary employee is "+employee.getEmpName());
            }
        });
    }
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(2, 1, 4, 1, 2, 5, 5, 7, 2, 8);
        System.out.println("Integer  :" + " Frequency");
        Map<Integer, Long> IntMap = integerList.stream()
                .collect(Collectors
                        .groupingBy(Function.identity(), Collectors.counting()));
        IntMap.forEach((key, value) -> System.out.println(key + "  " + value));
        System.out.println("---------------------------------------------------------------------");
        employeeOperations();
    }
}
