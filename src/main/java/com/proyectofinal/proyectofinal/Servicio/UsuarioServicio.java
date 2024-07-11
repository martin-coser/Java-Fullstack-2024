
package com.proyectofinal.proyectofinal.Servicio;
import com.proyectofinal.proyectofinal.modelo.Usuario;
import java.util.List;
import java.util.Optional;

public interface UsuarioServicio {
    
    public void Registrar (Usuario usuario);
    Optional<Usuario> encontrarPorEmailYContrasena(String email, String contrasena);
    List<Usuario> listarUsuarios();
}
