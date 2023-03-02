package com.edge.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.edge.restapi.security","com.edge.restapi.controller","com.edge.restapi.excepciones","com.edge.restapi.modelo","com.edge.restapi.paths", "com.edge.restapi.repository", "com.edge.restapi.service" })
@EnableAutoConfiguration
public class SimpleCustomerRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleCustomerRestApiApplication.class, args);
	}

}
