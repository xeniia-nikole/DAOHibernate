package com.example.repository;

import com.example.model.Person;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class EntityRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> getPersonsByCity(String city) {
        return entityManager.createQuery(
                        "select p from Person p where p.cityOfLiving = :city", Person.class)
                .setParameter("city", city)
                .getResultList();
    }
}