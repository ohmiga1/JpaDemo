package com.example.JpaDemo.repository;

import com.example.JpaDemo.model.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
