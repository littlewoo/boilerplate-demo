package com.github.littlewoo.boilerplate.jdbc;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class HashMappingMain {
    public static void main(String[] args) {
        User user = new User(UUID.randomUUID(), "john@littlewood.se", "12345678");
        Map<User, String> usersRequests = new HashMap<>();
        usersRequests.put(user, user.requestId);

        User user2 = new User(user.id, user.email, user.requestId);
        System.out.println(usersRequests.get(user2));
    }
}
