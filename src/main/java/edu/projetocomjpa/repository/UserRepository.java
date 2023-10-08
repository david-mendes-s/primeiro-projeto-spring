package edu.projetocomjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;
import edu.projetocomjpa.model.User;


public interface UserRepository extends JpaRepository<User, Integer>{
    public User deleteById(String id);
    public Optional<User> findById(String id);
}
