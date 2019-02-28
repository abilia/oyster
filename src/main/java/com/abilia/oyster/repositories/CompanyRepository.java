package com.abilia.oyster.repositories;

import com.abilia.oyster.models.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CompanyRepository {

    private static final String GET_COMPANIES =
            "SELECT * FROM companies";

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public CompanyRepository(DataSource dataSource) {
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public List<Company> getCompanies() {
        return jdbcTemplate.query(GET_COMPANIES, CompanyRepository::rsToCompany);
    }

    private static Company rsToCompany(ResultSet rs, int _rowNum) throws SQLException {
        return new Company(rs.getInt("id"), rs.getString("company"), rs.getString("city"));
    }
}
