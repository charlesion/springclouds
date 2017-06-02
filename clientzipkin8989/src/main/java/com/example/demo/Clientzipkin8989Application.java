package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
@RestController
public class Clientzipkin8989Application {

	public static void main(String[] args) {
		SpringApplication.run(Clientzipkin8989Application.class, args);
	}
	private static final Logger LOG = Logger.getLogger(Clientzipkin8989Application.class.getName());


	@RequestMapping("/hello8989")
	public String home(){
		LOG.log(Level.INFO, "hello8989 is being called");
		return "hi i'm hello8989!";
	}

	@RequestMapping("/to8988")
	public String info(){
		LOG.log(Level.INFO, "calling trace to8988");
		return restTemplate.getForObject("http://localhost:8988/hello8988",String.class);
	}

	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
}
