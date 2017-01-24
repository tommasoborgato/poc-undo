package com.example.jpa.undodb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by icttb0 on 20/01/2017.
 */
@Transactional("undoTransactionManager")
public interface NodeBkpRepository extends JpaRepository<NodeBkp,Long>{
    Collection<NodeBkp> findByName(String name);
}