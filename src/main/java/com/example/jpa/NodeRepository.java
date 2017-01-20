package com.example.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

/**
 * Created by icttb0 on 20/01/2017.
 */
public interface NodeRepository extends JpaRepository<Node,Long>{
    Collection<Node> findByName(String name);
}