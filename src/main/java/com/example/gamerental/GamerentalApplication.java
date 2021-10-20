package com.example.gamerental;

import com.example.gamerental.library.GameDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.Path;
import java.nio.file.Paths;

import static com.example.gamerental.library.GameDAO.DEFAULT_PATH;

@SpringBootApplication
public class GamerentalApplication {

	public static void main(String[] args) {
		SpringApplication.run(GamerentalApplication.class, args);
	}

}
