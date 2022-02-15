package com.example.controller;

import com.example.model.Person;
import com.example.service.EntityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EntityController {
    EntityService entityService;

    public EntityController(EntityService entityService) {
        this.entityService = entityService;
    }

    @GetMapping("/persons/by-city")
    public List<Person> getPersonsByCity(@RequestParam("city") String city) {
        return entityService.getPersonsByCity(city);
    }

}
