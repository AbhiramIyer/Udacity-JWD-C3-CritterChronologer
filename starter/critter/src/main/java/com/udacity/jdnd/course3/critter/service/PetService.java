package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.Entity.Pet;
import com.udacity.jdnd.course3.critter.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {
    private PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }

    public Pet getById(long petId) {
        return petRepository.getOne(petId);
    }

    public List<Pet> getAll() {
        return petRepository.findAll();
    }

    public List<Pet> getByOwnerId(long ownerId) {
        return petRepository.findAllByCustomerId(ownerId);
    }
}
