package com.java.employee.management.system.controller;

import com.java.employee.management.system.dto.EmployeeVO;
import com.java.employee.management.system.repository.EmployeeRepository;
import com.java.employee.management.system.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/employee")

public class EmployeeController {
    private EmployeeService employeeService;
    private final EmployeeRepository employeeRepository;


    public EmployeeController(EmployeeService employeeService,
                              EmployeeRepository employeeRepository) {
        this.employeeService = employeeService;

        this.employeeRepository = employeeRepository;
    }

    @PostMapping()
    public ResponseEntity addEmployee(@RequestBody EmployeeVO vo) {
        var payload = employeeService.addEmployee(vo);
        return ResponseEntity.status(payload.getEmployeeId()).body(payload);
    }

    @DeleteMapping("/delete/{employeeID}")
    public ResponseEntity deleteEmployee(@PathVariable("employeeID") Long id) {
        var payload = employeeService.deleteEmployee(id);
        return ResponseEntity.status(payload.getEmployeeId()).body(payload);
    }
    @GetMapping ("/search/{employeeId}")
    public ResponseEntity getEmployee (@PathVariable ("employeeId") Long id){
        var payload = employeeService.getEmployee(id);
        return ResponseEntity.status(payload.getEmployeeId()).body(payload);
    }
    @PutMapping("update/{employeeId}")
    public ResponseEntity updateEmployee (@PathVariable ("employeeId") Long id, @RequestBody EmployeeVO vo){
        var payload = employeeService.updateEmployee (id, vo);
        return ResponseEntity.status(payload.getEmployeeId()).body(payload);
    }
    @GetMapping("/listall")
    public List listAllEmployees(){
        return employeeRepository.findAll();
    }

}

