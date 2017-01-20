package com.example.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

/**
 * Created by icttb0 on 20/01/2017.
 */
public interface TrailBkpRepository extends JpaRepository<TrailBkp,Long> {
    Collection<TrailBkp> findByName(String name);
}
