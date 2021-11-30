package com.wordpress.papatohu.papatohubackend.repository;

import com.wordpress.papatohu.papatohubackend.model.UConfig;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.UUID;

public interface ItemRepository extends MongoRepository<UConfig, String> {

    @Query("{id:'?0'}")
    UConfig findItemByID(UUID id);

    public long count();

}
