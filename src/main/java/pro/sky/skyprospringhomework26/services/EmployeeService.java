package pro.sky.skyprospringhomework26.services;

import pro.sky.skyprospringhomework26.Employee;

import java.util.List;

public interface EmployeeService {

    Employee addNewEmployee(String firstName, String lastName);

    Employee deleteEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);
    List<Employee> getEmployees();
}
