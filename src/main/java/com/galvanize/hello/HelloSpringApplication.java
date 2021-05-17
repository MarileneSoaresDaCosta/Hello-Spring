package com.galvanize.hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args);
	}

	@Value("${app.server.id}")
	private int serverId;

	@GetMapping("/sid")
	public String getServerId(){
		return "The server id is '"+serverId+"'";
	}

	@GetMapping("/hello")
	public String sayHello(@RequestParam(defaultValue = "World") String name){
		return String.format("Hello %s", name);
	}
}
