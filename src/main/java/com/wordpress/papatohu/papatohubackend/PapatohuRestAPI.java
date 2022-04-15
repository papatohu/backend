package com.wordpress.papatohu.papatohubackend;

import com.wordpress.papatohu.papatohubackend.model.UConfig;
import com.wordpress.papatohu.papatohubackend.repository.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@EnableMongoRepositories
@RestController
public class PapatohuRestAPI {

    @Autowired
    ItemRepository UConfigRepo;

    Logger logger = LoggerFactory.getLogger(PapatohuRestAPI.class);

    @PostMapping("/newUser")
    public UConfig conf(@RequestBody UConfig config) {
        config.setId(UUID.randomUUID().toString());
        UConfigRepo.save(config);
        logger.info("created new User Config");
        return config;
    }

    @GetMapping("/get/{id}")
    public UConfig getConfig(@PathVariable String id) {
        UConfig item = UConfigRepo.findItemByID(id);
        logger.info("request user config");
        return item;
    }

    @GetMapping("/authenticate")
    public UConfig authUser(@RequestBody UConfig config) {
        UConfig item = UConfigRepo.findItemByID(config.getUsername());
        if (config.getPw().equals(item.getPw())) {
            return item;
        } else {
            return new UConfig("ERROR", "wrong Password", "", "");
        }
    }

}
