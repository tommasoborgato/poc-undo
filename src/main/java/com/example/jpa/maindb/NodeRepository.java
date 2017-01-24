package com.example.jpa.maindb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by icttb0 on 20/01/2017.
 */
@Transactional("mainTransactionManager")
public interface NodeRepository extends JpaRepository<Node,Long>{
    Collection<Node> findByName(String name);
}