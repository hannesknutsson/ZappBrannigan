package com.github.hannesknutsson.zappbrannigan;

import org.springframework.boot.SpringApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableScheduling
@SpringBootApplication
public class ZappBranniganApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZappBranniganApplication.class, args);
	}
}
