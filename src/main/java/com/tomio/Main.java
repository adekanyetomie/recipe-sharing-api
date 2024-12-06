package com.tomio;

import com.tomio.user.UserProfile;
import com.tomio.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@SpringBootApplication
//        (exclude = {DataSourceAutoConfiguration.class})
public class Main {
    public static  void main(String[] args) {
            SpringApplication.run(Main.class, args);
    }
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Bean
    CommandLineRunner runner(UserRepository userRepository) {
        return args -> {
            List<UserProfile> users = List.of(
                    new UserProfile("Dami", "dami@gmail.com", encoder.encode("1234567")),
                    new UserProfile("Tomi", "tomi@gmail.com", encoder.encode("3456789")),
                    new UserProfile("Thomas", "thomas@gmail.com", encoder.encode("fhmlk34567")),
                    new UserProfile("Temi", "temi@gmail.com", encoder.encode("14526567"))
            );
            userRepository.saveAll(users);
        };
    }
}
