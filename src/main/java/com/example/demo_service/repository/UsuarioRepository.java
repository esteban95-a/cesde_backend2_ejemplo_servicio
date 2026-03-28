package com.example.demo_service.repository;

import com.example.demo_service.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio para la entidad Usuario.
 * Extiende JpaRepository para obtener operaciones CRUD básicas automáticamente.
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    /**
     * Ejemplo de un "Query Method": Spring Data JPA genera la consulta automáticamente
     * basándose en el nombre del método.
     */
    Optional<Usuario> findByEmail(String email);

    /**
     * Ejemplo de consulta personalizada utilizando JPQL (Java Persistence Query Language).
     * Esto permite definir lógica de consulta más compleja que no se puede inferir solo
     * por el nombre del método.
     */
    @Query("SELECT u FROM Usuario u WHERE u.edad >= :min AND u.edad <= :max")
    List<Usuario> buscarPorRangoDeEdad(@Param("min") Integer min, @Param("max") Integer max);
}
