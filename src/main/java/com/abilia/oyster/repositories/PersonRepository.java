package com.abilia.oyster.repositories;

import com.abilia.oyster.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class PersonRepository {

    private static final String GET_PERSONS =
            "SELECT * FROM persons";

    private static final String GET_PERSON =
            "SELECT * FROM persons WHERE id=";

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public PersonRepository(DataSource dataSource) {
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    private static final RowMapper<Person> MAPPER_PERSON =
            (rs, i) -> new Person(rs.getInt("id"), rs.getString("full_name"));

    public static <T> ResultSetExtractor singletonExtractor(
            RowMapper<? extends T> mapper) {
        return rs -> rs.next() ? mapper.mapRow(rs, 1) : null;
    }

    private static final ResultSetExtractor<Person> EXTRACTOR_PERSON =
            singletonExtractor(MAPPER_PERSON);

    public List<Person> getAllPersons() {
        return jdbcTemplate.query(GET_PERSONS, MAPPER_PERSON);
    }


    public Person getPerson(Integer personId) {
        return jdbcTemplate.query(GET_PERSON + "'" + personId + "'", EXTRACTOR_PERSON);
    }


}
