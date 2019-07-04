package com.example.demo5;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.nio.charset.CoderMalfunctionError;

@SpringBootApplication
public class Demo5Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo5Application.class, args);

    }

    @Bean
    public CommandLineRunner runner(ClientRepository clientRepository){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                for (int i = 0; i < 10 ; i++) {
                    Client client = new Client("Name" + i, "name"+ i + "gmail.com");
                 clientRepository.save(client);

                }
            }
        };
    }
}
