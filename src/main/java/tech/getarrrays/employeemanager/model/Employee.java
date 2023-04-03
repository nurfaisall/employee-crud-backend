package tech.getarrrays.employeemanager.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    //name email jobtitle phome
    private String name;
    private String email;
    private String jobTitle;
    private String phone;
    private String imgUrl;
    @Column(nullable = false, updatable = false)
    private String employeeCode;
}
