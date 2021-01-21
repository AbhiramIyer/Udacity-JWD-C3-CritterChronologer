package com.udacity.jdnd.course3.critter.Entity;

import com.udacity.jdnd.course3.critter.pet.PetType;
import lombok.Data;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Pet {
    @Id
    @GeneratedValue
    private Long id;

    @Nationalized
    private String name;

    @Enumerated(EnumType.STRING)
    private PetType petType;

    private LocalDate dateOfBirth;

    private String note;

    @ManyToOne(optional = false)
    private Customer customer;
}
