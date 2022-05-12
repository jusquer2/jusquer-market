package com.jusquer.market.persistence.crud;

import com.jusquer.market.persistence.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsuarioCrudRepository extends CrudRepository<Usuario,Integer> {
    Optional<Usuario> findByUsername(String username);
}
