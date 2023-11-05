package com.backend.forumavalburo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(CorsConfig.class)
public class ForumAvalBuroApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForumAvalBuroApplication.class, args);
	}

}
