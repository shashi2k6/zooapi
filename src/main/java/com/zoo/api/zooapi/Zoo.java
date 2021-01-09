package com.zoo.api.zooapi;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Zoo {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Animal animal;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
