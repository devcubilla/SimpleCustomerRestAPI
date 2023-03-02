package com.edge.restapi.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CustomerServiceTest {
	@Autowired
	CustomerService customerService;
	
    @DisplayName("Test Spring @Autowired Integration")
    @Test
    void testGet() {
        //assertEquals("Hello JUnit 5", customerService));
    }
}
