package com.chinganshih.movie;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MovieDataAccessService implements MovieDao {

    private final JdbcTemplate jdbcTemplate;

    public MovieDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Movie> selectMovies() {
        String sql = """
                SELECT id, mname, release_date
                FROM movie                          
                LIMIT 100;
                """;
        return jdbcTemplate.query(sql, new MovieRowMapper());
    }

    @Override
    public int insertMovie(Movie movie) {
        String sql = """
             INSERT INTO movie(mname, release_date) 
             VALUES (?,?);
               """;

        return jdbcTemplate.update(sql, movie.name(), movie.releaseDate());

    }

    @Override
    public int deleteMovie(int id) {
        String sql = """
                DELETE FROM movie 
                WHERE id = ?;                
                """;
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public Optional<Movie> selectMovieById(int id) {
        String sql = """
                SELECT id, mname, release_date
                FROM movie                          
                where id = ?;                
                """;

        return jdbcTemplate.query(sql, new MovieRowMapper(), id).stream().findFirst();

    }
    @Override
    public int updateMovie(int id, Movie movie){
        String sql = """
                UPDATE movie
                SET id = ?, 
                mname = ?,
                release_date = ?
                where id = ?; 
                """;
        return jdbcTemplate.update(sql, id, movie.name(), movie.releaseDate(),id);
    }
    
}
