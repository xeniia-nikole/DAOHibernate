package com.example.controller;

import com.example.model.Person;
import com.example.service.EntityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class EntityController {
    final EntityService service;

    public EntityController(EntityService service) {
        this.service = service;
    }


    @GetMapping("/persons/by-city")
    public List<Person> getNameByCity(@RequestParam("city") String city) {
        return service.findByCityOfLiving(city);
    }

    @GetMapping("/persons/by-person")
    public Optional<Person> getPersonByNameAndSurname(@RequestParam("name") String name,
                                                      @RequestParam("surname") String surname) {
        return service.findPersonByPersonId_NameAndAndPersonId_Surname(name, surname);
    }
    @GetMapping("/persons/by-age")
    public List<Person> getPersonsByAge(@RequestParam("age") int age) {
        return service.findAllByPersonId_AgeLessThanOrderByPersonId_Age(age);
    }
}
