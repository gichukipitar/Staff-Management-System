package com.java.employee.management.system.service;

import com.java.employee.management.system.dto.EmployeeDTO;
import com.java.employee.management.system.dto.EmployeeVO;
import com.java.employee.management.system.entity.Employee;
import com.java.employee.management.system.repository.EmployeeRepository;
import com.java.employee.management.system.utils.Payload;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Payload addEmployee(EmployeeVO vo) {
        Employee bean = new Employee();
        BeanUtils.copyProperties(vo,bean);
        var employee = employeeRepository.save(bean);
        return Payload.builder()
                .employeeId(HttpStatus.OK.value())
                .message("employee " + employee.getFirstName() + " added successfully")
                .build();
    }

    public Payload deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
        var employee = checkEmployeeId(id);
        if (employee.isEmpty()){
            return Payload.builder()
                    .employeeId(HttpStatus.OK.value())
                    .message("employee " + id + " deleted successfully")
                    .build();
        } else {
            return Payload.builder()
                    .employeeId(HttpStatus.BAD_REQUEST.value())
                    .message("employee with " + id + " not deleted successfully")
                    .build();
        }
    }

    private Optional <Employee> checkEmployeeId(Long id) {
        return employeeRepository.findById(id);
    }

    public Payload getEmployee(Long id) {
        var originalEmployee = checkEmployeeId(id);
        var employee = toDTO (originalEmployee.get());
        return Payload.builder()
                .employeeId(HttpStatus.OK.value())
                .message("Fetched company successfully")
                .data(employee)
                .build();
    }

    private EmployeeDTO toDTO(Employee originalEmployee) {
        EmployeeDTO bean = new EmployeeDTO();
        BeanUtils.copyProperties(originalEmployee, bean);
        return bean;
    }

    public Payload updateEmployee(Long id, EmployeeVO vo) {
        var bean = checkEmployeeId(id);
        BeanUtils.copyProperties(vo, bean.get());
        var updatedEmployee = employeeRepository.save(bean.get());
        return Payload.builder()
                .employeeId(HttpStatus.OK.value())
                .message("company updated successfully")
                .data(updatedEmployee)
                .build();
    }
}
