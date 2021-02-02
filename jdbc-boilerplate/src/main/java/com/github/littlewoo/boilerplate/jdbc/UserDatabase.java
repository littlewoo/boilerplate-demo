package com.github.littlewoo.boilerplate.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.postgresql.ds.PGSimpleDataSource;

public class UserDatabase {
    private final static String TABLE_NAME = "msamigration_cohort_assignments";
    private final static String INSERT = "INSERT INTO " + TABLE_NAME  + " (user_uuid, cohort) VALUES (?, ?)";

    private final Connection connection;
    private final PreparedStatement stmnt;

    public UserDatabase() throws SQLException {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setURL("jdbc:mysql://localhost:3306");
        dataSource.setDatabaseName("users");
        dataSource.setUser("appuser");
        dataSource.setPassword("password");

        this.connection = dataSource.getConnection();
        this.stmnt = connection.prepareStatement(INSERT);
    }

    public CompletableFuture saveUsers(List<User> users) {
        return CompletableFuture.runAsync(() -> {
            try {
                for (User user : users) {
                    stmnt.setObject(1, user.id);
                    stmnt.setString(2, user.email);
                    stmnt.addBatch();
                }
                stmnt.executeBatch();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }
}
