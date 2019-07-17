package com.ea.ecommerceorderservicebackend;

import com.ea.ecommerceorderservicebackend.configuration.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableConfigurationProperties({
		FileStorageProperties.class
})
@SpringBootApplication
@EnableEurekaClient
public class ECommerceOrderServiceBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceOrderServiceBackendApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
}
