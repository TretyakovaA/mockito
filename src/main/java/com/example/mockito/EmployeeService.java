package com.example.mockito;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
    public class EmployeeService {
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


        public Employee findEmployee(Employee employee) throws EmployeeNotFoundException {
            if (!employees.contains(employee)) {
                throw new EmployeeNotFoundException();
            }
            return employee;
        }

        public Employee addEmployee(Employee employee) throws BadRequest, EmployeeAlreadyAddedException {
            if (employees.contains(employee)) {
                throw new EmployeeAlreadyAddedException();
            }
            if (employee.getFirstName().matches("^[a-zA-Z]*$") && employee.getLastName().matches("^[a-zA-Z]*$")) {
                employees.add(employee);
                return employee;
            } else
                throw new BadRequest();
        }

        public Employee deleteEmployee(Employee employee) {
            if (!employees.contains(employee)) {
                throw new EmployeeNotFoundException();
            }
            employees.remove(employee);
            return employee;
        }

    }

