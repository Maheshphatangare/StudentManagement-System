package com.mongo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableAutoConfiguration

@ComponentScan(basePackages={"com.mongo.repo", "com.mongo.controller"})
@EnableMongoRepositories(basePackages = "com.mongo.repo")
//@EnableTransactionManagement
@EntityScan(basePackages={"com.mongo.entity"})

//@ComponentScan(basePackages = "com.smart.repo")

//(scanBasePackages={
//"com.smart.repo", "com.smart.controller","com.smart.entities"})
@SpringBootApplication
public class MongodemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongodemoApplication.class, args);
	}

}
