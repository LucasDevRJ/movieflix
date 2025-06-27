package br.com.movieflix.service;

import br.com.movieflix.entity.Category;
import br.com.movieflix.entity.Movie;
import br.com.movieflix.entity.Streaming;
import br.com.movieflix.repository.MovieRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRespository movieRespository;
    private final CategoryService categoryService;
    private final StreamingService streamingService;

    public Movie save(Movie movie) {
        movie.setCategories(this.findCategories(movie.getCategories()));
        movie.setStreamings(this.findStreamings(movie.getStreamings()));
        return movieRespository.save(movie);
    }

    public List<Movie> findAll() {
        return movieRespository.findAll();
    }

    public Optional<Movie> findMovieById(Long id) {
        return movieRespository.findById(id);
    }

    private List<Category> findCategories(List<Category> categories) {
        List<Category> categoriesFound = new ArrayList<>();
        for (Category category : categories) {
            categoryService.findCategoryById(category.getId()).ifPresent(categoriesFound::add);
        }
        return categoriesFound;
    }

    private List<Streaming> findStreamings(List<Streaming> streamings) {
        List<Streaming> streamingsFound = new ArrayList<>();
        for (Streaming streaming : streamings) {
            streamingService.findStreamingById(streaming.getId()).ifPresent(streamingsFound::add);
        }
        return streamingsFound;
    }
}
