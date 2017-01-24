package com.example.jpa.maindb;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by icttb0 on 20/01/2017.
 */
@Entity
public class Trail {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Trail() {
    }

    public Trail(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Trail{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
