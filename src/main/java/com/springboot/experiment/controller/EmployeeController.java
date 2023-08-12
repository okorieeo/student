package com.springboot.experiment.controller;

import com.springboot.experiment.model.Employee;
import com.springboot.experiment.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        System.out.println(employee.getFirstName());

        System.out.println(employee.getLastName());
        System.out.println(employee.getEmail());
        System.out.println(employee);
        System.out.println(employee.getId());



        //        Employee employee1 = new Employee("Emmanuel", "okoirie", "nick@gmail.com");
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
//        return new ResponseEntity<Employee>(employeeService.saveEmployee(Employee.lastName="okorie", firstName), HttpStatus.CREATED);

    }
    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId){
        return  new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
    }

//    @GetMapping("/{email}")
//    public ResponseEntity<Employee> getEmployeeByEmail( String email){
//        return  new ResponseEntity<Employee>(employeeService.getEmployeeByEmail(email), HttpStatus.OK);
//    }

//    @GetMapping("{email}")
//    public Employee getEmployeeByEmail(String email){
//        return  employeeService.getEmployeeByEmail(email);
//    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long employeeId, @RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, employeeId), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long employeeId, Employee employee){
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<String>("Employee deleted successfully", HttpStatus.OK);
    }
}
