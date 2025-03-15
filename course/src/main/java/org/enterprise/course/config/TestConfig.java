package org.enterprise.course.config;

import org.enterprise.course.entities.User;
import org.enterprise.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Maria Brown", "Maria@gmail.com", "9999999", "299216");
        User u2 = new User(null, "Alex Green", "Alex@gmail.com", "8888888", "5351889");

        userRepository.saveAll(Arrays.asList(u1, u2));
    }







}
