package com.abilia.oyster.repositories;

import com.abilia.oyster.models.Occupation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class OccupationRepository {


    private static final String GET_OCCUPATIONS =
            "SELECT * FROM occupations";

    private static final String GET_OCCUPATION =
            "SELECT * FROM occupations WHERE company_id=";

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public OccupationRepository(DataSource dataSource) {
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public List<Occupation> getOccupations() {
        return jdbcTemplate.query(GET_OCCUPATIONS, OccupationRepository::rsToOccupation);
    }

    public List<Occupation> getOccupationsFromCompanyId(Integer companyId) {
        return jdbcTemplate.query(GET_OCCUPATION + "'" + companyId + "'", OccupationRepository::rsToOccupation);
    }

    private static Occupation rsToOccupation(ResultSet rs, int _rowNum) throws SQLException {
        return new Occupation(rs.getInt("person_id"), rs.getInt("company_id"), rs.getString("occupation"));
    }
}
