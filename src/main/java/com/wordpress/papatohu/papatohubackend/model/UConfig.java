package com.wordpress.papatohu.papatohubackend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document("UConfig")
public class UConfig {

    @Id
    private UUID id;

    private String username;
    private String pw;
    private List<String> tileConfigs;

    public UConfig(String username, String pw, List<String> tileConfigs) {
        this.id = UUID.randomUUID();
        this.username = username;
        this.pw = pw;
        this.tileConfigs = tileConfigs;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public List<String> getTileConfigs() {
        return tileConfigs;
    }

    public void setTileConfigs(List<String> tileConfigs) {
        this.tileConfigs = tileConfigs;
    }
}
