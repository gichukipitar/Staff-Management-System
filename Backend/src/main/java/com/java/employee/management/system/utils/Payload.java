package com.java.employee.management.system.utils;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
@Data
@Builder
public class Payload <T>{
    private final int employeeId;
    private final String name;
    private final String message;
    private T data;
}
