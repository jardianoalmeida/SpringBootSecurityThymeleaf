package com.jardiano.springsecurity.resouce;

import com.jardiano.springsecurity.model.Usuario;
import com.jardiano.springsecurity.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class CategoriaResource {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

}