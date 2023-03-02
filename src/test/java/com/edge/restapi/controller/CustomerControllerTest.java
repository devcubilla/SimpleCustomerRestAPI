package com.edge.restapi.controller;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest()
public class CustomerControllerTest {
	@Autowired
	CustomerController customerController;
	
	@DisplayName("Test - App Loads Correctly")
	@Test
	public void contextLoads() {
		Assertions.assertThat(customerController).isNotNull();
	}

}
