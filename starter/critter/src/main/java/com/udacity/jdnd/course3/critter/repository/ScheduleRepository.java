package com.udacity.jdnd.course3.critter.repository;

import com.udacity.jdnd.course3.critter.Entity.Customer;
import com.udacity.jdnd.course3.critter.Entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findByPetsId(Long id);
    List<Schedule> findByEmployeesId(Long id);
    List<Schedule> findByPetsCustomerId(Long id);
/*
    List<Schedule> findAllByPetsId(Long id);
    List<Schedule> findAllByEmployeesId(Long id);
    List<Schedule> findAllByCustomersId(Long id);
*/
}
