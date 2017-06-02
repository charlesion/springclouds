package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
@RestController
public class Clientzipkin8988Application {

	public static void main(String[] args) {
		SpringApplication.run(Clientzipkin8988Application.class, args);
	}

	private static final Logger LOG = Logger.getLogger(Clientzipkin8988Application.class.getName());


	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

	@RequestMapping("/hello8988")
	public String callHome(){
		LOG.log(Level.INFO, "calling trace hello8988  ");

		return "i'm hello8988";
	}
	@RequestMapping("/to8989")
	public String info(){
		LOG.log(Level.INFO, "calling trace to8989 ");
		return restTemplate.getForObject("http://localhost:8989/hello8989", String.class);
	}

	@Bean
	public AlwaysSampler defaultSampler(){
		return new AlwaysSampler();
	}
}
