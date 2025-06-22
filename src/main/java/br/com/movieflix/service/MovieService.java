package br.com.movieflix.service;

import br.com.movieflix.repository.MovieRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRespository movieRespository;

}
