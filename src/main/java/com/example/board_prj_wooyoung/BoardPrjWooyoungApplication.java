package com.example.board_prj_wooyoung;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BoardPrjWooyoungApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardPrjWooyoungApplication.class, args);
	}

}
