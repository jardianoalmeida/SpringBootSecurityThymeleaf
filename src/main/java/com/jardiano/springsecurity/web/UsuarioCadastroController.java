package com.jardiano.springsecurity.web;

import com.jardiano.springsecurity.model.Usuario;
import com.jardiano.springsecurity.service.UsuarioService;
import com.jardiano.springsecurity.web.dto.UsuarioRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class UsuarioCadastroController {

    @Autowired
    private UsuarioService usuarioService;

    @ModelAttribute("user")
    public UsuarioRegistrationDto userRegistrationDto() {
        return new UsuarioRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid UsuarioRegistrationDto userDto,
                                      BindingResult result){

        Usuario existing = usuarioService.findByEmail(userDto.getEmail());
        if (existing != null){
            result.rejectValue("email", null, "There is already an account registered with that email");
        }

        if (result.hasErrors()){
            return "registration";
        }

        usuarioService.save(userDto);
        return "redirect:/registration?success";
    }

}
