package net.javaguides.ems.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.EmployeeDto;

import net.javaguides.ems.services.EmployeeService;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;


    //build add employee REST API
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    //build get employee by id REST API
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId) {
        EmployeeDto employeeDto = employeeService.getEmployeeeById(employeeId);
        return ResponseEntity.ok(employeeDto);
    }

    //build get all employee rest Api
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployee() {
       List<EmployeeDto> employee = employeeService.getAllEmployees();
       return ResponseEntity.ok(employee);
    }


    //build update rest Api

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto>updateEmployee(@PathVariable ("id")Long employeeId,
    @RequestBody EmployeeDto updatedEmployee){
       EmployeeDto employeeDto = employeeService.updateEmployee(employeeId,updatedEmployee);
         return ResponseEntity.ok(employeeDto);
        
    }

    //build delete rest Api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee deleted successfully");
    }
}