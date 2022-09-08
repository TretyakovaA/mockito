package com.example.mockito;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

    @RestController
    @RequestMapping(path = "/employee")
    public class EmployeeController {
        private final EmployeeService employeeService;
        private final DepartmentService departmentService;

        public EmployeeController(EmployeeService employeeService, DepartmentService departmentService) {
            this.employeeService = employeeService;
            this.departmentService = departmentService;
        }

        @GetMapping("/find")
        public Employee findEmployee(Employee employee) {

            return employeeService.findEmployee(employee);
        }

        @GetMapping(path = "/add")
        public Employee addEmployee(Employee employee) {
            return employeeService.addEmployee(employee);
        }

        @GetMapping(path = "/delete")
        public Employee deleteEmployee(Employee employee) {

            return employeeService.deleteEmployee(employee);

        }

        @GetMapping(path = "/max-salary")
        public int maxSalary(Integer department) {
            return departmentService.maxSalary(department);
        }

        @GetMapping(path = "/min-salary")
        public int minSalary(Integer department) {
            return departmentService.minSalary(department);
        }

        @GetMapping(path = "/all")
        public List<Employee> allDep(Integer department) {
            return departmentService.allDep(department);
        }

        @GetMapping(path = "/allEmployee")
        public Map<Integer, List<Employee>> all() {
            return departmentService.all();
        }

    }


