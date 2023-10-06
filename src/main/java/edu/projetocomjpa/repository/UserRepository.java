package edu.projetocomjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.projetocomjpa.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    
}
