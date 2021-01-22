package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.Entity.Schedule;
import com.udacity.jdnd.course3.critter.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class SchedulingService {
    private ScheduleRepository scheduleRepository;

    public SchedulingService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public Schedule save(Schedule schedule) {

        return (Schedule) scheduleRepository.save(schedule);
    }

    public List<Schedule> getAll() {
        return scheduleRepository.findAll();
    }

    public Schedule getById(long scheduleId) {
        return scheduleRepository.getOne(scheduleId);
    }

    public List<Schedule> getScheduleForPet(long id) {
//        return scheduleRepository.findAllByPetsId(id);
        return scheduleRepository.findByPetsId(id);
    }

    public List<Schedule> getScheduleForEmployee(long employeeId) {
//        return scheduleRepository.findAllByEmployeesId(employeeId);
        return scheduleRepository.findByEmployeesId(employeeId);
    }

    public List<Schedule> getScheduleForCustomer(long customerId) {
//        return scheduleRepository.findAllByCustomersId(customerId);
        return scheduleRepository.findByPetsCustomerId(customerId);
    }
}
