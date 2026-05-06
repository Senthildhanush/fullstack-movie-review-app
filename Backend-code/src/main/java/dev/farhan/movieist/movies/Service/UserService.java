package dev.farhan.movieist.movies.Service;


import dev.farhan.movieist.movies.Model.User;
import dev.farhan.movieist.movies.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.springframework.util.ClassUtils.isPresent;


@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    @Autowired
    private AuthenticationManager authmanager;

    @Autowired
    private JWTService jwtService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);   //convert the password into hashcode

    public User register(User user) {

        Optional<User> existingUser = repo.findByUsername(user.getUsername());

        if (existingUser.isPresent()) {
            throw new RuntimeException("User already exists");
        }

        user.setPassword(encoder.encode(user.getPassword()));
        return  repo.save(user);
    }

    public String verify(User user)
    {
        Authentication authentication = authmanager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        if(authentication.isAuthenticated())
            return  jwtService.generateAuthtoken(user.getUsername());

        return "fail";
    }
}

