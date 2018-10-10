package com.rv.code.SpringWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.rv.code")
public class SpringWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebApplication.class, args);
	}
}
