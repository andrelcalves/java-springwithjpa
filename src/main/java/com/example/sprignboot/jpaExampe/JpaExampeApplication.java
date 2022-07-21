package com.example.sprignboot.jpaExampe;

import com.example.sprignboot.jpaExampe.dataprovider.client.TodoExampleClient;
import com.example.sprignboot.jpaExampe.dataprovider.database.repository.CategoryRepository;
import com.example.sprignboot.jpaExampe.dataprovider.database.repository.ProductRepository;
import com.example.sprignboot.jpaExampe.domain.model.Category;
import com.example.sprignboot.jpaExampe.domain.model.Product;
import com.example.sprignboot.jpaExampe.domain.model.enumerator.Color;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import com.example.sprignboot.jpaExampe.domain.model.Todo;
import java.math.BigDecimal;

@SpringBootApplication
@EnableFeignClients
public class JpaExampeApplication {


	private static final Logger log = LoggerFactory.getLogger(JpaExampeApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JpaExampeApplication.class, args);
	}


	@Autowired
	TodoExampleClient todoClient;
	@Bean
	public CommandLineRunner demo(ProductRepository repositoryProduct, CategoryRepository repositoryCategory) {
		return (args) -> {
			// Http client
			log.info("HttpClient getTodos():");
			log.info("-------------------------------");
			for (Todo todos: todoClient.getTodos()) {
				log.info(todos.getTitle());
			}

			// save a few categories
			Category mobile = new Category("Mobile");
			Category book = new Category("Book");
			repositoryCategory.save(mobile);
			repositoryCategory.save(book);

			// save a few products
			repositoryProduct.save(new Product("Samsung X20", "Mobile Samsung X20",new BigDecimal(800) , Color.WHITE,mobile));
			repositoryProduct.save(new Product("Iphone ProMax", "Mobile Iphone ProMax",new BigDecimal(1800) ,Color.BLACK,mobile));
			repositoryProduct.save(new Product("Motorola v9", "MMotorola v9",new BigDecimal(1800) ,Color.RED,mobile));
			repositoryProduct.save(new Product("Java for web", "Programming Java for Web", new BigDecimal(100),Color.NONE,book));


			// fetch all customers
			log.info("Products found with findAll():");
			log.info("-------------------------------");
			for (Product product : repositoryProduct.findAll()) {
				log.info(product.getDescription() + " - " + product.getCategory().getName());
			}
			log.info("");
			Product product = repositoryProduct.findById(2);
			log.info(product.getDescription());
			log.info("");

			log.info("");
			Product productBook = repositoryProduct.findByName("Java for web");
			log.info(productBook.getDescription());
			log.info("");

			log.info("");
			for (Product productCategory : repositoryProduct.findByCategory(mobile)) {
				log.info(productCategory.getDescription() + " - " + productCategory.getCategory().getName());
			}

			//test of removing a category - ERROR integrity constraint
			//Referential integrity constraint violation: "FK1MTSBUR82FRN64DE7BALYMQ9S: PUBLIC.PRODUCT FOREIGN KEY(CATEGORY_ID) REFERENCES PUBLIC.CATEGORY(ID) (CAST(2 AS BIGINT))"
			//repositoryCategory.delete(book);

		};
	}
}
