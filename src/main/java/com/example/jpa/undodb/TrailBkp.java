package com.example.jpa.undodb;

import com.example.jpa.maindb.Trail;

import javax.persistence.Entity;

/**
 * Created by icttb0 on 20/01/2017.
 */
@Entity
public class TrailBkp extends Trail {

    private CRUD crud;

    public TrailBkp() {
    }

    public CRUD getCrud() {
        return crud;
    }

    public void setCrud(CRUD crud) {
        this.crud = crud;
    }

    @Override
    public String toString() {
        return "TrailBkp{" +
                "crud=" + crud +
                '}';
    }
}
