package com.zoo.api.zooapi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Animal {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String type;
    private String moods;

    public Animal() {
    }

    public Animal( String name, String type, String moods) {
        this.name = name;
        this.type = type;
        this.moods = moods;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMoods() {
        return moods;
    }

    public void setMoods(String moods) {
        this.moods = moods;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
