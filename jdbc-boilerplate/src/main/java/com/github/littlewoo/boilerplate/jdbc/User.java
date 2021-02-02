package com.github.littlewoo.boilerplate.jdbc;

import java.util.UUID;

public class User {
    public final UUID id;
    public final String email;

    public User(final UUID id, final String email) {
        this.id = id;
        this.email = email;
    }
}
