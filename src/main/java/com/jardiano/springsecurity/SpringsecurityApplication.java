package com.jardiano.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringsecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringsecurityApplication.class, args);
        System.out.println("-----------------------------------------");
        BCrypt();
    }

    public static  void BCrypt() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println("-----------------------------------------");
            String senha = encoder.encode("123456");

            // senha
            System.out.println(senha); // print hash

            // true para todas as 5 iterações
            System.out.println(encoder.matches("123456", senha));
            System.out.println("-----------------------------------------");
    }
}

