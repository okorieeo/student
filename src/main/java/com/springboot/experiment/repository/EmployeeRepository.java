package com.springboot.experiment.repository;

import com.springboot.experiment.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByEmail(String email);

    void deleteByEmail(String email);
}
