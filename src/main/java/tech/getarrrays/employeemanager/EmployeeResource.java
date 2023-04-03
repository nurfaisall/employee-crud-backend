package tech.getarrrays.employeemanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.getarrrays.employeemanager.model.Employee;
import tech.getarrrays.employeemanager.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeResource {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> findAllEmployee(){
        List<Employee> employees = employeeService.findAllEmployee();
        return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> findById(@PathVariable("id")Long id){
        Employee employee = employeeService.findById(id);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee newEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<Employee>(newEmployee, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> putEmployee(@RequestBody Employee employee){
        Employee updateEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<Employee>(updateEmployee, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id")Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
