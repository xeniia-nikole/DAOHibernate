package com.example.repository;

import com.example.model.Person;
import com.example.model.PersonId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface EntityRepository extends JpaRepository<Person, PersonId> {

    List<Person> findByCityOfLiving(String city);

    @SuppressWarnings("SpringDataMethodInconsistencyInspection")
    Optional<Person> findPersonByPersonId_NameAndAndPersonId_Surname(String name, String surname);

    List<Person> findAllByPersonId_AgeLessThanOrderByPersonId_Age(int age);

}