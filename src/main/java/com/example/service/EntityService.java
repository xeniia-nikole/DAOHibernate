package com.example.service;

import com.example.model.Person;
import com.example.repository.EntityRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EntityService {
    private final EntityRepository repository;


    public EntityService(EntityRepository repository) {
        this.repository = repository;
    }

   public List<Person> getPersonsByCity(String city) {
        return repository.getPersonsByCity(city);
    }

}
