package database.model;

import lombok.*;

@Builder
@Value
public class User {
    Integer id;
    String username;
}
