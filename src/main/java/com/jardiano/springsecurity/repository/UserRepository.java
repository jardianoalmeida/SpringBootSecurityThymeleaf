package com.jardiano.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jardiano.springsecurity.model.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {
	Usuario findByEmail(String email);
}
