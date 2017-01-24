package com.example.jpa.undodb;

import com.example.jpa.maindb.Node;

import javax.persistence.Entity;

/**
 * Created by icttb0 on 20/01/2017.
 */
@Entity
public class NodeBkp extends Node {

    private CRUD crud;

    public NodeBkp() {
    }

    public CRUD getCrud() {
        return crud;
    }

    public void setCrud(CRUD crud) {
        this.crud = crud;
    }

    @Override
    public String toString() {
        return "NodeBkp{" +
                "crud=" + crud +
                '}';
    }
}
