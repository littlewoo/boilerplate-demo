package com.github.littlewoo.boilerplate.jdbc;

import java.util.Objects;
import java.util.UUID;

public class User {
    public final UUID id;
    public final String email;
    public transient final String requestId;

    public User(final UUID id, final String email, final String requestId) {
        this.id = id;
        this.email = email;
        this.requestId = requestId;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final User user = (User) o;
        return Objects.equals(id, user.id) &&
                   Objects.equals(email, user.email) &&
                   Objects.equals(requestId, user.requestId);
    }
}
