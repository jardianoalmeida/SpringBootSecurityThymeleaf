package com.jardiano.springsecurity.service;

import com.jardiano.springsecurity.model.Usuario;
import com.jardiano.springsecurity.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    Usuario findByEmail(String email);

    Usuario save(UserRegistrationDto registration);
}
