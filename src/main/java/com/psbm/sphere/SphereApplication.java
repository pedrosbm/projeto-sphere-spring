package com.psbm.sphere;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SphereApplication {

	public ResponseEntity<String> origin(){
		return ResponseEntity.ok("Happy hacking!");
	}

	public static void main(String[] args) {
		SpringApplication.run(SphereApplication.class, args);
	}

}
