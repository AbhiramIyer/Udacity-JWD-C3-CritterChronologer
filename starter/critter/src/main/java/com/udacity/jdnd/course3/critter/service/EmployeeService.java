package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.Entity.Employee;
import com.udacity.jdnd.course3.critter.repository.EmployeeRepository;
import com.udacity.jdnd.course3.critter.user.EmployeeSkill;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Employee getById(long employeeId) {
        return employeeRepository.getOne(employeeId);
    }

    public boolean isAvailable(Set<DayOfWeek> daysAvailable, LocalDate date) {
        return daysAvailable.contains(date.getDayOfWeek());
    }

    public boolean hasRequiredSkill(Set<EmployeeSkill> employeeSkills, Set<EmployeeSkill> requiredSkills) {
        return employeeSkills.containsAll(requiredSkills);
    }

    public List<Employee> findEmployeesForService(Set<EmployeeSkill> requiredSkills, LocalDate requiredDate) {
        return getAll()
                    .stream()
                    .filter(employee -> hasRequiredSkill(employee.getSkills(), requiredSkills))
                    .filter(employee -> isAvailable(employee.getDaysAvailable(), requiredDate))
                    .collect(Collectors.toList());
    }
}
