package com.chinganshih.movie;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class MovieRowMapper implements RowMapper<Movie>{

    @Override
    public Movie mapRow(ResultSet resultSet, int id) throws SQLException{
        return new Movie(
                resultSet.getInt("id"),
                resultSet.getString("mname"),
                List.of(),
                LocalDate.parse(resultSet.getString("release_date"))
        );
    }
}
