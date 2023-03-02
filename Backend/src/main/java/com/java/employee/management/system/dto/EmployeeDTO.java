package com.java.employee.management.system.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.java.employee.management.system.entity.Employee} entity
 */
@Data
public class EmployeeDTO implements Serializable {
   private Long id;
   private String emailId;
   private String firstName;
   private String lastName;
}