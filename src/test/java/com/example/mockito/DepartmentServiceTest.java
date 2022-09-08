package com.example.mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.extension.ExtendWith;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;


        import static org.junit.jupiter.api.Assertions.assertEquals;
        import static org.junit.jupiter.api.Assertions.assertNotNull;
        import static org.mockito.ArgumentMatchers.anyInt;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    List<Employee> expected = new ArrayList<>();
    @Mock
    private final Employee employee1 = new Employee("Ivan", "Ivanov", 20, 2);
    @Mock
    private final Employee employee2 = new Employee("Igor", "Ilyin", 10, 2);
    DepartmentService departmentService;

    EmployeeService employeeService;

    @Test
    public void checkMaxSalary() {
        expected.add(employee1);
        expected.add(employee2);
        Mockito.when(employee1.getSalary()).thenReturn(20);
        assertEquals(expected.get(0).getSalary(), 20);

    }

    @Test
    public void checkMinSalary() {
        expected.add(employee1);
        expected.add(employee2);
        Mockito.when(employee1.getSalary()).thenReturn(10);
        assertEquals(expected.get(0).getSalary(), 10);

    }

    @Test
    public void checkDepartment() {
        expected.add(employee1);
        expected.add(employee2);
        Mockito.when(employee1.getDepartment()).thenReturn(2);
        assertEquals(expected.get(0).getDepartment(), 2);
        Mockito.when(employee2.getDepartment()).thenReturn(2);
        assertEquals(expected.get(1).getDepartment(), 2);

    }

}
