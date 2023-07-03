package com.works.repositories;

import com.works.entities.Footbollers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

public interface FootbollersRepository extends JpaRepository<Footbollers, Integer> {
    ResponseEntity<Footbollers> findByEmailEqualsAndPasswordEquals(String email, String password);

    Footbollers findByEmail(String email);


}