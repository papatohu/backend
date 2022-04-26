package com.wordpress.papatohu.papatohubackend;

import com.wordpress.papatohu.papatohubackend.model.UConfig;
import com.wordpress.papatohu.papatohubackend.repository.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@EnableMongoRepositories
@RestController
public class PapatohuRestAPI {

    @Autowired
    ItemRepository UConfigRepo;

    Logger logger = LoggerFactory.getLogger(PapatohuRestAPI.class);

    @PutMapping("/newUser")
    public UConfig newUser(@RequestBody UConfig config) {
        config.setId(UUID.randomUUID().toString());
        UConfigRepo.save(config);
        logger.info("created new User");
        return config;
    }

    @GetMapping("/getConfig/{id}")
    public Object getConfig(@PathVariable String id) {
        UConfig item = UConfigRepo.findItemByID(id);
        logger.info("return config");
        return item.getTileConfigs();
    }

    @PostMapping("updateConfig/{id}")
    public Object updateConfig(@PathVariable String id, @RequestBody Object newConfig) {
        UConfig item = UConfigRepo.findItemByID(id);
        item.setTileConfigs(newConfig);
        UConfigRepo.save(item);
        logger.info("saved new config");
        return newConfig;
    }

    @GetMapping("/get/{id}")
    public UConfig getUser(@PathVariable String id) {
        UConfig item = UConfigRepo.findItemByID(id);
        logger.info("request user config");
        return item;
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable String id) {
        try {
            UConfig item = UConfigRepo.findItemByID(id);
            UConfigRepo.delete(item);
        } catch (Exception e) {
            logger.info("Request to delete non existing User");
            return "User does not exist";
        }
        logger.info("User: \'" + id + "\' was deleted");
        return "User: \'" + id + "\' was deleted";
    }

    /**
     * Work in Progress
     */
    @GetMapping("/login/{username}")
    public UConfig authUser(@PathVariable String username, @RequestBody String pw) {
        UConfig item = UConfigRepo.findItemByName(username);
        if (pw.equals(item.getPw())) {
            return item;
        } else {
            return new UConfig("ERROR", "wrong Password", "", "");
        }
    }

}
