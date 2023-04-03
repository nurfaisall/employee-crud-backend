package tech.getarrrays.employeemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrrays.employeemanager.exeption.IdNotFoundException;
import tech.getarrrays.employeemanager.model.Employee;
import tech.getarrrays.employeemanager.repo.EmployeeRepo;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo){
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployee(){
        return employeeRepo.findAll();
    }

    public Employee findById(Long id){
        return employeeRepo.findById(id).orElseThrow(()-> new IdNotFoundException("id" + id + "is Not Found"));
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public void deleteEmployee(Long id){
        employeeRepo.deleteById(id);
    }
}
