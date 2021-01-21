package com.udacity.jdnd.course3.critter.Entity;

import com.udacity.jdnd.course3.critter.user.EmployeeSkill;
import lombok.Data;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.Set;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue
    Long id;

    @Nationalized
    String name;

    @ElementCollection
    @Enumerated
    Set<EmployeeSkill> skills;

    @ElementCollection
    @Enumerated
    Set<DayOfWeek> daysAvailable;
}
