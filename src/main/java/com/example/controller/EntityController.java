package com.example.controller;

import com.example.model.Person;
import com.example.service.EntityService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Optional;

@RestController
public class EntityController {
    final EntityService service;

    public EntityController(EntityService service) {
        this.service = service;
    }


    @GetMapping("/persons/by-city")
    @Secured("ROLE_READ")
    public List<Person> getNameByCity(@RequestParam("city") String city) {
        return service.findByCityOfLiving(city);
    }

    @GetMapping("/persons/by-person")
    @RolesAllowed("ROLE_WRITE")
    public Optional<Person> getPersonByNameAndSurname(@RequestParam("name") String name,
                                                      @RequestParam("surname") String surname) {
        return service.findPersonByPersonId_NameAndAndPersonId_Surname(name, surname);
    }
    @GetMapping("/persons/by-age")
    @PreAuthorize("hasRole('ROLE_WRITE') or hasRole('ROLE_DELETE')")
    public List<Person> getPersonsByAge(@RequestParam("age") int age) {
        return service.findAllByPersonId_AgeLessThanOrderByPersonId_Age(age);
    }
    @GetMapping("/username")
    @PostAuthorize("#username == authentication.principal.username")
    public String named(String username) {
        return username + " entered the building.";
    }
}
