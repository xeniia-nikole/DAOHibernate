package com.example.service;

import com.example.model.Person;
import com.example.repository.EntityRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EntityService {
    private final EntityRepository repository;


    public EntityService(EntityRepository repository) {
        this.repository = repository;
    }

    public List<Person> findByCityOfLiving(String city){
        return repository.findByCityOfLiving(city);
    }

    public Optional<Person> findPersonByPersonId_NameAndAndPersonId_Surname(String name, String surname){
        return repository.findPersonByPersonId_NameAndAndPersonId_Surname(name,surname);
    }

    public List<Person> findAllByPersonId_AgeLessThanOrderByPersonId_Age(int age){
        return repository.findAllByPersonId_AgeLessThanOrderByPersonId_Age(age);
    }

}
