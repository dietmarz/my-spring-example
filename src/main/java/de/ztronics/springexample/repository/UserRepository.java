package de.ztronics.springexample.repository;


import de.ztronics.springexample.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
