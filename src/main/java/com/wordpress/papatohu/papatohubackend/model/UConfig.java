package com.wordpress.papatohu.papatohubackend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("UConfig")
public class UConfig {

    @Id
    private String id;

    private String username;
    private String pw;
    private Object tileConfigs;

    public UConfig(String id, String username, String pw, Object tileConfigs) {
        this.id = id;
        this.username = username;
        this.pw = pw;
        this.tileConfigs = tileConfigs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Object getTileConfigs() {
        return tileConfigs;
    }

    public void setTileConfigs(Object tileConfigs) {
        this.tileConfigs = tileConfigs;
    }
}
