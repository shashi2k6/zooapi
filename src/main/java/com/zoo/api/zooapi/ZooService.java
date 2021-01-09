package com.zoo.api.zooapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZooService {

    @Autowired
    private ZooRepository zooRepository;

    public Zoo addAnimal(Zoo zoo){
        return zooRepository.save(zoo);
    }
}
