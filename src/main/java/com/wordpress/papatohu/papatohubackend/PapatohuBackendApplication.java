package com.wordpress.papatohu.papatohubackend;

import com.wordpress.papatohu.papatohubackend.model.UConfig;
import com.wordpress.papatohu.papatohubackend.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.UUID;

@SpringBootApplication
@EnableMongoRepositories
public class PapatohuBackendApplication implements CommandLineRunner {

    @Autowired
    ItemRepository UConfigRepo;


    public static void main(String[] args) {
        SpringApplication.run(PapatohuBackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }

    //Create UConfig

    //  Get item by name
    public void getGroceryItemByName(UUID id) {
        System.out.println("Getting item by name: " + id);
        UConfig item = UConfigRepo.findItemByID(id);
    }

    //Upadte

    //Delete
}
