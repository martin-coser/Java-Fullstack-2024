package com.proyectofinal.proyectofinal.ControladorUsuario;

import com.proyectofinal.proyectofinal.Servicio.UsuarioServicio;
import com.proyectofinal.proyectofinal.modelo.Usuario;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class ControladorUsuario {
    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        return "index";
    }
    
    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "registro";
    }
   
    @PostMapping("/registro")
    public String registrarUsuario(@ModelAttribute("usuario") Usuario usuario, BindingResult result) {
        if (result.hasErrors()) {
            return "registro";
        }
        usuarioServicio.Registrar(usuario);
        return "redirect:/";
    }
    
    @GetMapping("/login")
    public String mostrarFormularioLogin(Model model) {
        model.addAttribute("loginForm", new Usuario());
        return "login";
    }
    
    @PostMapping("/login")
    public String login(@ModelAttribute("loginForm") Usuario loginForm, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "login";
        }
        Optional<Usuario> usuario = usuarioServicio.encontrarPorEmailYContrasena(loginForm.getEmail(), loginForm.getContrasena());
        if (usuario.isPresent()) {
            return "sesion"; 
        } else {
            model.addAttribute("loginError", "Email o contraseña incorrectos");
            return "login";
        }
    } 
    
    @GetMapping("/lista")
    public String mostrarListaUsuarios(Model model) {
        List<Usuario> usuarios = usuarioServicio.listarUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "lista";
    }

}   