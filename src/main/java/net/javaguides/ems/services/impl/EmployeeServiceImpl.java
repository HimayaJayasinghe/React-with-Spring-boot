package net.javaguides.ems.services.impl;

import net.javaguides.ems.services.EmployeeService;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.entity.Employee;
import net.javaguides.ems.exceptions.ResourceNotFoundException;
import net.javaguides.ems.mapper.EmployeeMapper;
import net.javaguides.ems.repository.EmployeeRepository;


@Service
@AllArgsConstructor

public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        Employee savedEmployee =  employeeRepository.save(employee);
        
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}

    @Override
    public EmployeeDto getEmployeeeById(Long employeeId) {

       Employee employee = employeeRepository.findById(employeeId)
        .orElseThrow(() -> 
        new ResourceNotFoundException("Employee is not found with given id: "+employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
        
    }


}
