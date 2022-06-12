package com.example.sprignboot.jpaExampe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.sprignboot.jpaExampe.domain.model.Product;
import com.example.sprignboot.jpaExampe.infra.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class JpaExampeApplication {


	private static final Logger log = LoggerFactory.getLogger(JpaExampeApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JpaExampeApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ProductRepository repository) {
		return (args) -> {
			// save a few products
			repository.save(new Product("Samsung X20", "Mobile Samsung X20",new BigDecimal(800) ));
			repository.save(new Product("Iphone ProMax", "Mobile Iphone ProMax",new BigDecimal(1800) ));
			repository.save(new Product("Motorola v9", "MMotorola v9",new BigDecimal(1800) ));

			// fetch all customers
			log.info("Products found with findAll():");
			log.info("-------------------------------");
			for (Product product : repository.findAll()) {
				log.info(product.getDescription());
			}
			log.info("");
		};
	}
}
