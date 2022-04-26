package com.wordpress.papatohu.papatohubackend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PapatohuBackendApplicationTests {

    @Test
    void contextLoads() {
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


}
