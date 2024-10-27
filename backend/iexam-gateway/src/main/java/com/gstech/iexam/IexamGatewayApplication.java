package com.gstech.iexam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class IexamGatewayApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(IexamGatewayApplication.class)
				.web(WebApplicationType.REACTIVE) // Enforce reactive mode
				.run(args);
		//SpringApplication.run(IexamGatewayApplication.class, args);
	}

}
