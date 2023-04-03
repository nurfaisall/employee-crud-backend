package tech.getarrrays.employeemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.getarrrays.employeemanager.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}
