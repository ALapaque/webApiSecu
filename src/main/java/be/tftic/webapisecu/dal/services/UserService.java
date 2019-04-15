package be.tftic.webapisecu.dal.services;

import be.tftic.webapisecu.dal.entities.Users;
import be.tftic.webapisecu.dal.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Objects.requireNonNull(username);
        Users u = repo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return u;
    }
}
