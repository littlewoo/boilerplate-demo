package com.github.littlewoo.boilerplate.springmagic;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.EqualsAndHashCode;

@Entity
@EqualsAndHashCode
public class User {
    @Id
    public UUID id;
    public String email;
    public transient String requestId;

    public User() {
    }
}
