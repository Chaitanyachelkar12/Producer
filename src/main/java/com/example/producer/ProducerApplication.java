package com.example.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class ProducerApplication implements CommandLineRunner {

    @Autowired
    private ProducerService producerService;

	public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        producerService.sendInitialMessage("Hello from Producer");
    }
}
