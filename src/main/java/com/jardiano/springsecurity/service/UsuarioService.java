package com.jardiano.springsecurity.service;

import com.jardiano.springsecurity.model.Usuario;
import com.jardiano.springsecurity.web.dto.UsuarioRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsuarioService extends UserDetailsService {

    Usuario findByEmail(String email);

    Usuario save(UsuarioRegistrationDto registration);
}
