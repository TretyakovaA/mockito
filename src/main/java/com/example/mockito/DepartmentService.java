package com.example.mockito;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Comparator;

@Service
    public class DepartmentService {
        private List<Employee> employees = new ArrayList<>(Arrays.asList(
                new Employee("Elijah", "Powell", 100000, 1),
                new Employee("Connor", "Mitchell", 120000, 2),
                new Employee("Dylan", "Lopez", 200000, 3),
                new Employee("Jayden", "Martin", 130000, 3),
                new Employee("Sebastian", "Cook", 90000, 3),
                new Employee("Leslie", "Adams", 150000, 4),
                new Employee("Paige", "Barnes", 120000, 4),
                new Employee("Isabella", "Ross", 100000, 1),
                new Employee("Arianna", "Sanders", 135000, 5),
                new Employee("Caroline", "Flores", 111000, 5)));


        EmployeeService employeeService = new EmployeeService();


        public int maxSalary(Integer department) {
            return employees.stream()
                    .filter(e -> e.getDepartment().equals(department))
                    .map(Employee::getSalary).max(Comparator.naturalOrder()).get();
        }
        public int minSalary(Integer department) {
            return employees.stream()
                    .filter(e -> e.getDepartment().equals(department))
                    .map(Employee::getSalary).min(Comparator.naturalOrder()).get();
        }
        public List<Employee> allDep(Integer department) {
            return employees.stream()
                    .filter(e -> e.getDepartment().equals(department))
                    .collect(Collectors.toList());
        }
        public Map<Integer, List<Employee>> all() {
            Map<Integer, List<Employee>> employeesByDep = employees
                    .stream()
                    .collect(Collectors.groupingBy(Employee::getDepartment));
            return employeesByDep;
        }
    }

