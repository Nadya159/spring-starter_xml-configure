package database.repository;

import database.model.User;
import utils.ConnectionPool;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

public class UserRepository {
    private final ConnectionPool connectionPool;

    private final static String FIND_BY_ID_SQL = """
            SELECT id, username
            FROM users
            WHERE id = ?
            """;

    public UserRepository(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public Optional<User> findUserById(Integer id) throws SQLException {
        try (PreparedStatement statement = connectionPool.getConnection().prepareStatement(FIND_BY_ID_SQL)) {
            statement.setInt(1, id);
            var result = statement.executeQuery();
            User user = null;
            if (result.next()) {
                user = User.builder()
                        .id(result.getInt("id"))
                        .username(result.getString("username"))
                        .build();
            }
            return Optional.ofNullable(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
