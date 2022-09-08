package com.example.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.example.mockito.Constns.*;

public class EmployeeServiceTest {
    private EmployeeService employeeService = new EmployeeService();
    @ParameterizedTest
    @MethodSource ("provideStringsForBlanks")

    public void checkAddEmployee (Employee employee){
        employeeService.addEmployee(employee);
    }
    @ParameterizedTest
    @MethodSource ("provideStringsForBlanks")

    public void checkFindEmployee (Employee employee){
        checkAddEmployee(employee);
        employeeService.findEmployee(employee);
    }
    @ParameterizedTest
    @MethodSource ("provideStringsForBlanks")

    public void checkDeleteEmployee (Employee employee){
        checkAddEmployee(employee);
        employeeService.deleteEmployee(employee);
    }
    private static Stream<Arguments> provideStringsForBlanks(){
        return Stream.of(Arguments.of(CORRECT_EMPLOYEE), Arguments.of(SIMILAR_EMPLOYEE1), Arguments.of(SIMILAR_EMPLOYEE2));
    }
}
