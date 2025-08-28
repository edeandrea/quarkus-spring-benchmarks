package com.example;

import org.testcontainers.containers.PostgreSQLContainer;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;

@TestConfiguration(proxyBeanMethods = false)
public class ContainersConfig {
	@Bean
	@ServiceConnection
	public PostgreSQLContainer<?> postgres() {
		return new PostgreSQLContainer<>("postgres:17")
			.withInitScript("schema.sql");
	}
}
