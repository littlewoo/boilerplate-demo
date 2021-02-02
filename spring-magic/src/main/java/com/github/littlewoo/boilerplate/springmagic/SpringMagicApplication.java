package com.github.littlewoo.boilerplate.springmagic;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
public class SpringMagicApplication {
    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringMagicApplication.class, args);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void save() {
        User user = new User();
        user.email = "john@littlewood.se";
        user.id = UUID.randomUUID();
        userRepository.save(user);
    }
}
