package pro.sky.skyprospringhomework26.services;

import org.springframework.stereotype.Service;
import pro.sky.skyprospringhomework26.Employee;
import pro.sky.skyprospringhomework26.exceptions.EmployeeAlreadyAddedException;
import pro.sky.skyprospringhomework26.exceptions.EmployeeNotFoundException;
import pro.sky.skyprospringhomework26.exceptions.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private List<Employee> employees = new ArrayList<>();
    private int maxEmployees = 5;

    public Employee addNewEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.size() >= maxEmployees) {
            throw new EmployeeStorageIsFullException("The list of employees is full");
        }
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Employee is already in the list");
        }
        employees.add(employee);
        return employee;
    }

    public Employee deleteEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("Employee is not found");
        }
        employees.remove(employee);
        return employee;
    }

    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("Employee is not found");
        } else return employee;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
