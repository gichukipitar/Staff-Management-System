package com.java.employee.management.system.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "employee")

public class Employee {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}