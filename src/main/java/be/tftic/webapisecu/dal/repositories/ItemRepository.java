package be.tftic.webapisecu.dal.repositories;

import be.tftic.webapisecu.dal.entities.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

@PreAuthorize("hasRole('ROLE_USER')")
@Repository
public interface ItemRepository extends JpaRepository<Items, Long> {

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    <S extends Items> S save(S entity);
}
