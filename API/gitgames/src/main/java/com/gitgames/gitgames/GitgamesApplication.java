package com.gitgames.gitgames;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@OpenAPIDefinition(
		info = @Info
				(
						title = "GitGames",
						description = "API para gerenciamento de produtos de uma loja de games",
						version = "1.0"
				)

)
public class GitgamesApplication {

	public static void main(String[] args) {
		SpringApplication.run(GitgamesApplication.class, args);
	}

}
