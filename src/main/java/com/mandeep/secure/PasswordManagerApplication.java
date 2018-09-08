package com.mandeep.secure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableCaching
public class PasswordManagerApplication {
    public static void main(String[] args) {

        SpringApplication.run(PasswordManagerApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder getEncoder() {

        return new BCryptPasswordEncoder();
    }
}

