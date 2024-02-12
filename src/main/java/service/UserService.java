package service;

import database.model.User;
import database.repository.UserRepository;

import java.sql.SQLException;
import java.util.Optional;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findUserById(Integer id) throws SQLException {
        return userRepository.findUserById(id);
    }
}
