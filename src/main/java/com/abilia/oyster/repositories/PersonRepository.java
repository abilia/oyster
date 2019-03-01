package com.abilia.oyster.repositories;

import com.abilia.oyster.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PersonRepository {

    private static final String GET_PERSONS =
            "SELECT * FROM persons";

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public PersonRepository(DataSource dataSource) {
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public List<Person> getAllPersons() {
        return jdbcTemplate.query(GET_PERSONS, PersonRepository::rsToPerson);
    }

    private static Person rsToPerson(ResultSet rs, int _rowNum) throws SQLException {
        return new Person(rs.getInt("id"), rs.getString("full_name"));
    }
}
