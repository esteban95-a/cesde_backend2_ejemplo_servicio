package com.example.demo_service.service;

import com.example.demo_service.model.entity.Usuario;
import com.example.demo_service.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Clase de servicio que contiene la lógica de negocio de la aplicación.
 * El controlador llama al servicio, y el servicio interactúa con el repositorio.
 */
@Service
@RequiredArgsConstructor // Genera el constructor para la inyección de dependencias (UsuarioRepository)
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    /**
     * Ejemplo de Lógica de Negocio: 
     * Antes de guardar, validamos condiciones específicas.
     */
    public Usuario guardarUsuario(Usuario usuario) {
        // Regla 1: El usuario debe ser mayor de edad
        if (usuario.getEdad() < 18) {
            throw new RuntimeException("Lógica de Negocio: El usuario debe ser mayor de 18 años.");
        }

        // Regla 2: El email no debe estar registrado previamente
        if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
            throw new RuntimeException("Lógica de Negocio: El email ya está en uso.");
        }

        return usuarioRepository.save(usuario);
    }

    /**
     * Uso de método personalizado del repositorio.
     */
    public List<Usuario> buscarPorEdad(Integer min, Integer max) {
        return usuarioRepository.buscarPorRangoDeEdad(min, max);
    }

    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
    }
}
