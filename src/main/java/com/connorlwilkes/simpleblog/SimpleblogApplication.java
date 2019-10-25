package com.connorlwilkes.simpleblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SimpleblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleblogApplication.class, args);
    }

}
