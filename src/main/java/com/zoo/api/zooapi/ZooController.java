package com.zoo.api.zooapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ZooController {

    @Autowired
    private ZooService zooService;

    @PostMapping("/api/zoo")
    public Zoo addAnimal(@RequestBody Zoo zoo){
        return zooService.addAnimal(zoo);
    }

    @GetMapping("/api/zoo")
    public List<Zoo> getAnimal(){
        return zooService.getAllAnimals();
    }
}
