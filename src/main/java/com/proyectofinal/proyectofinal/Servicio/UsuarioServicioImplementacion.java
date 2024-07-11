package com.proyectofinal.proyectofinal.Servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyectofinal.proyectofinal.modelo.Usuario;
import com.proyectofinal.proyectofinal.repository.UsuarioRepository;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicioImplementacion implements UsuarioServicio{
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void Registrar(Usuario usuario) {
        usuarioRepository.save(usuario);
    }
    
    @Override
    public Optional<Usuario> encontrarPorEmailYContrasena(String email, String contrasena) {
        return usuarioRepository.findByEmailAndContrasena(email, contrasena);
    }
    
    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }
}