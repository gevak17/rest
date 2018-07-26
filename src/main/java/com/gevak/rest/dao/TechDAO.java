package com.gevak.rest.dao;

import com.gevak.rest.entity.Tech;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechDAO extends JpaRepository<Tech, Integer> {
}
