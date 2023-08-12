package com.springboot.experiment.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;
@Data
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @SequenceGenerator( name="employee_sequence", sequenceName = "employee_sequence", allocationSize = 1)
    @GeneratedValue( generator = "employee_sequence", strategy = GenerationType.SEQUENCE)
    private  Long id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private  String lastName;
    @Email
    @Column(name = "email", nullable = false, unique = true)
    private  String email;

}
