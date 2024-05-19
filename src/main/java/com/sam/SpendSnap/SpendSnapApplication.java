package com.sam.SpendSnap;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@OpenAPIDefinition(
		info = @Info(
				title = "SpendSnap API Documentation",
				description = "Expense Tracker Application - REST API Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Sam",
						email = "sam@gmail.com",
						url = "https://github.com/Sam-v-b"
				),
				license = @License(
						name = "Apache 2.0"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "SpendSnap API Documentation for developers",
				url = "https://github.com/Sam-v-b"
		)
)
@SpringBootApplication
public class SpendSnapApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpendSnapApplication.class, args);
	}

}
