package com.example.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

/**
 * Created by icttb0 on 20/01/2017.
 */
public interface TrailRepository extends JpaRepository<Trail,Long> {
    Collection<Trail> findByName(String name);
}
