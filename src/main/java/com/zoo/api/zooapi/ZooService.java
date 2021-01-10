package com.zoo.api.zooapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZooService {

    @Autowired
    private ZooRepository zooRepository;

    public Zoo addAnimal(Zoo zoo){
        return zooRepository.save(zoo);
    }

    public List<Zoo> getAllAnimals() {
       return zooRepository.findAll();
    }
}
