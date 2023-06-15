package pro.sky.skyprospringhomework26.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyprospringhomework26.Employee;
import pro.sky.skyprospringhomework26.exceptions.EmployeeAlreadyAddedException;
import pro.sky.skyprospringhomework26.exceptions.EmployeeNotFoundException;
import pro.sky.skyprospringhomework26.exceptions.EmployeeStorageIsFullException;
import pro.sky.skyprospringhomework26.services.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee addNewEmployee(@RequestParam("firstName") String firstName,
                                   @RequestParam("lastName") String lastName) {

        try {
            employeeService.addNewEmployee(firstName, lastName);
        } catch (EmployeeStorageIsFullException e) {
            throw new RuntimeException();
        } catch (EmployeeAlreadyAddedException e) {
            throw new RuntimeException();
        }
        Employee employee = new Employee(firstName, lastName);
        return employee;
    }

    @GetMapping(path = "/remove")
    public Employee deleteEmployee(@RequestParam("firstName") String firstName,
                                   @RequestParam("lastName") String lastName) {
        try {
            employeeService.deleteEmployee(firstName, lastName);
        } catch (EmployeeNotFoundException e) {
            throw new RuntimeException();
        }
        Employee employee = new Employee(firstName, lastName);
        return employee;
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName) {
        try{
            employeeService.findEmployee(firstName, lastName);
        } catch (EmployeeNotFoundException e){
            throw new RuntimeException();
        }
        Employee employee = new Employee(firstName, lastName);
        return employee;
    }

    @GetMapping(path = "/print")
    public List<Employee> printEmployees(){
        return employeeService.getEmployees();
    }

}
