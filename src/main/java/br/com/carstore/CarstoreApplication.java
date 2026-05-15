package br.com.carstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "br.com.carstore.model")
@EnableJpaRepositories(basePackages = "br.com.carstore.repository")
public class CarstoreApplication {
	public static void main(String[] args) {
		SpringApplication.run(CarstoreApplication.class, args);
	}
}