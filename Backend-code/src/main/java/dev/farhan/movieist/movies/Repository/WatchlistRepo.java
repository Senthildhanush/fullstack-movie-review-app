package dev.farhan.movieist.movies.Repository;

import dev.farhan.movieist.movies.Model.Movie;

import java.util.List;

public interface WatchlistRepo {
    void addToWatchlist(String username, String movieId);
    List<Movie> getWatchlist(String username);
    void removeFromWatchlist(String username, String movieId);
}