package com.github.littlewoo.boilerplate.springmagic;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

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

    @EventListener(ApplicationStartedEvent.class)
    public void map() {
        User user = new User();
        user.email = "john@littlewood.se";
        user.id = UUID.randomUUID();
        user.requestId = "12345678";

        Map<User, String> usersRequests = new HashMap<>();
        usersRequests.put(user, user.requestId);

        User user2 = new User();
        user2.id = user.id;
        user2.email = user.email;
        user2.requestId = user.requestId;
        System.out.println(usersRequests.get(user2));
    }
}
