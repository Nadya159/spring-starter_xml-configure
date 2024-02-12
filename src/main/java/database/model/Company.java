package database.model;

import lombok.*;

@Builder
@Value
public class Company {
    Integer id;
    String name;
}
