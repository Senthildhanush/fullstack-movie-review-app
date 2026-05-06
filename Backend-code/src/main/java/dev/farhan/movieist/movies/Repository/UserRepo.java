package dev.farhan.movieist.movies.Repository;

import dev.farhan.movieist.movies.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepo extends MongoRepository<User, String> {

    Optional<User> findByUsername(String username);
}