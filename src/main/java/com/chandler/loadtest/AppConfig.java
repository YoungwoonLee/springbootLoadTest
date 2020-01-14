package com.chandler.loadtest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan(basePackages = {"com.chandler.loadtest"})
public class AppConfig {
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
}
