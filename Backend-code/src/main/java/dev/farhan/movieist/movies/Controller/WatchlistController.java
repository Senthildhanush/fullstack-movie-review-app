package dev.farhan.movieist.movies.Controller;

import dev.farhan.movieist.movies.Model.Movie;
import dev.farhan.movieist.movies.Service.WatchlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/watchList")
@RequiredArgsConstructor
public class WatchlistController
{

    private final WatchlistService watchlistService;

    @PostMapping("/add/{movieId}")
    public ResponseEntity<String> addToWatchlist(
            @PathVariable String movieId,
            Authentication authentication) {

        watchlistService.addToWatchlist(authentication.getName(), movieId);
        return ResponseEntity.ok("Movie added to watchlist successfully");
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getWatchlist(Authentication authentication) {
        return ResponseEntity.ok(
                watchlistService.getWatchlist(authentication.getName())
        );
    }

        @DeleteMapping("/{movieId}")
        public ResponseEntity<String> removeFromWatchlist(
                @PathVariable String movieId,
                Authentication authentication){

            watchlistService.removeFromWatchlist(authentication.getName(), movieId);
            return ResponseEntity.ok("Movie removed from watchlist successfully");
        }

}