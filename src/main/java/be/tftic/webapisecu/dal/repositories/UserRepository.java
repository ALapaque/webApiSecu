package be.tftic.webapisecu.dal.repositories;

import be.tftic.webapisecu.dal.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    //revient a faire une requete JPQL
    Optional<Users> findByUsername(String username);
}
