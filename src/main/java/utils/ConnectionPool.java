package utils;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Getter
public record ConnectionPool(String url,
                             String username,
                             Integer poolSize,
                             String password) {

    private void init() {
        System.out.println("Init connection pool");
    }

    private void destroy() {
        System.out.println("Clean connection pool");
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(url(), username(), password());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
