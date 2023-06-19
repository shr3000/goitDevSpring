package com.cron;

import com.cron.config.FlywayConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GoitDevSpringApplication {

	public static void main(String[] args) {
		FlywayConfig.migrate("jdbc:h2:D:/GOITDev/goITDevSpring/noteDB");
		SpringApplication.run(GoitDevSpringApplication.class, args);
	}

}
