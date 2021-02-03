package com.github.littlewoo.boilerplate.jdbc;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class DBSavingMain {
    public static void main(String[] args) throws SQLException {
        UserDatabase db = new UserDatabase();
        db.saveUsers(List.of(new User(UUID.randomUUID(), "john@littlewood.se", "12345678")));
    }
}
