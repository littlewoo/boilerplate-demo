package com.github.littlewoo.boilerplate.springmagic;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    public UUID id;
    public String email;

    public User() {
    }
}
