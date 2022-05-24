package com.wordpress.papatohu.papatohubackend;

import com.wordpress.papatohu.papatohubackend.model.UConfig;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PapatohuBackendApplicationTests {

    private UConfig testUser = new UConfig("", "Junit_Test", "Secure123", "Hello");

    @Autowired
    private PapatohuRestAPI restAPI;

    @Test
    @Order(1)
    public void contextLoads() throws Exception {
        assertThat(restAPI).isNotNull();
    }

    @Test
    @Order(2)
    public void testServer() throws Exception {
        assertThat(restAPI.testServerSimple()).contains("Hello World!");
    }

    @Test
    @Order(3)
    public void testNewUser() {
        UConfig serverReturn = restAPI.newUser(testUser);
        testUser.setId(serverReturn.getId());
        assertThat(serverReturn.getUsername()).isEqualTo(testUser.getUsername());
        assertThat(serverReturn.getPw()).isEqualTo(testUser.getPw());
        restAPI.deleteUser(serverReturn.getId());
    }

    @Test
    @Order(4)
    public void testGetUser() {
        UConfig serverReturn = restAPI.newUser(testUser);
        testUser.setId(serverReturn.getId());
        UConfig getUser = restAPI.getUser(serverReturn.getId());
        assertThat(serverReturn.getId()).isEqualTo(getUser.getId());
        assertThat(serverReturn.getUsername()).isEqualTo(getUser.getUsername());
        assertThat(serverReturn.getPw()).isEqualTo(getUser.getPw());
        assertThat(serverReturn.getTileConfigs()).isEqualTo(getUser.getTileConfigs());
        restAPI.deleteUser(serverReturn.getId());
    }

    @Test
    @Order(5)
    public void testGetConfig() {
        UConfig serverReturn = restAPI.newUser(testUser);
        testUser.setId(serverReturn.getId());
        Object config = restAPI.getConfig(serverReturn.getId());
        assertThat(testUser.getTileConfigs()).isEqualTo(config);
        restAPI.deleteUser(serverReturn.getId());
    }

    @Test
    @Order(6)
    public void testSetConfig() {
        UConfig serverReturn = restAPI.newUser(testUser);
        testUser.setId(serverReturn.getId());
        Object config = "Welt";
        assertThat(testUser.getTileConfigs()).isEqualTo("Hello");
        serverReturn.setTileConfigs(restAPI.updateConfig(serverReturn.getId(), config));
        assertThat(config).isEqualTo(serverReturn.getTileConfigs());
        restAPI.deleteUser(serverReturn.getId());
    }

    @Test
    @Order(7)
    public void testDeleteUser() {
        assertThat("User does not exist").isEqualTo(restAPI.deleteUser(testUser.getId()));
    }
}
