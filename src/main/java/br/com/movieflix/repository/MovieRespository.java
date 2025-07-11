package br.com.movieflix.repository;

import br.com.movieflix.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRespository extends JpaRepository<Movie, Long> {
}
