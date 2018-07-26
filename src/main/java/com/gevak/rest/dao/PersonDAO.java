package com.gevak.rest.dao;

import com.gevak.rest.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDAO extends JpaRepository<Person, Integer> {
}
