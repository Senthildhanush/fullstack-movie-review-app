package dev.farhan.movieist.movies.Service;

import dev.farhan.movieist.movies.Model.Movie;
import dev.farhan.movieist.movies.Model.User;
import dev.farhan.movieist.movies.Repository.MovieRepository;
import dev.farhan.movieist.movies.Repository.UserRepo;
import dev.farhan.movieist.movies.Repository.WatchlistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchlistService implements WatchlistRepo {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void addToWatchlist(String username, String movieId) {

        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Movie movie = movieRepository.findMovieByImdbId(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        if (!user.getWatchlist().contains(movieId)) {
            user.getWatchlist().add(movieId); // store imdbId
            userRepo.save(user);
        }
    }

    @Override
    public List<Movie> getWatchlist(String username) {

        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Fetch all movies using imdbIds
        return user.getWatchlist().stream()
                .map(id -> movieRepository.findMovieByImdbId(id).orElse(null))
                .filter(movie -> movie != null)
                .toList();
    }

    @Override
    public void removeFromWatchlist(String username, String movieId) {

        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (user.getWatchlist().remove(movieId)) {
            userRepo.save(user);
        }
    }
}