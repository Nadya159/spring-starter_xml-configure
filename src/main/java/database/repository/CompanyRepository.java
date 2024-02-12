package database.repository;

import database.model.Company;
import utils.ConnectionPool;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

public class CompanyRepository {
    private final ConnectionPool connectionPool;

    private final static String FIND_BY_ID_SQL = """
            SELECT id, name
            FROM company
            WHERE id = ?
            """;

    private CompanyRepository(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public Optional<Company> findCompanyById(Integer id) throws SQLException {
        try (PreparedStatement statement = connectionPool.getConnection().prepareStatement(FIND_BY_ID_SQL)) {
            statement.setInt(1, id);
            var result = statement.executeQuery();
            Company company = null;
            if (result.next()) {
                company = Company.builder()
                        .id(result.getInt("id"))
                        .name(result.getString("name"))
                        .build();
            }
            return Optional.ofNullable(company);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
