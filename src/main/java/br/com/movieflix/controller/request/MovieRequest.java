package br.com.movieflix.controller.request;

import br.com.movieflix.entity.Category;
import br.com.movieflix.entity.Streaming;

import java.time.LocalDate;
import java.util.List;

public record MovieRequest(
        String title,
        String description,
        LocalDate releaseDate,
        double rating,
        List<Long> categories,
        List<Long> streamings
        ) {

}