package com.jardiano.springsecurity.service;

import com.jardiano.springsecurity.model.Funcao;
import com.jardiano.springsecurity.model.Usuario;
import com.jardiano.springsecurity.repository.UsuarioRepository;
import com.jardiano.springsecurity.web.dto.UsuarioRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Usuario findByEmail(String email){
        return usuarioRepository.findByEmail(email);
    }

    public Usuario save(UsuarioRegistrationDto registration){
        Usuario user = new Usuario();
        user.getNome(registration.getNome());
        user.setEmail(registration.getEmail());
        user.setPassword(passwordEncoder.encode(registration.getPassword()));
        user.setFuncaos(Arrays.asList(new Funcao("ROLE_USER")));
        return usuarioRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario user = usuarioRepository.findByEmail(email);
        if (user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                mapRolesToAuthorities(user.getFuncaos()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Funcao> funcaos){
        return funcaos.stream()
                .map(funcao -> new SimpleGrantedAuthority(funcao.getName()))
                .collect(Collectors.toList());
    }
}
