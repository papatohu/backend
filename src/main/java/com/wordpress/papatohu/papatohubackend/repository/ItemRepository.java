package com.wordpress.papatohu.papatohubackend.repository;

import com.wordpress.papatohu.papatohubackend.model.UConfig;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ItemRepository extends MongoRepository<UConfig, String> {

    @Query("{id:'?0'}")
    UConfig findItemByID(String id);

    @Query("{'username':'?0'")
    UConfig findItemByName(String username);

    long count();

}
