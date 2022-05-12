package com.jusquer.market.domain.service;

import com.jusquer.market.persistence.crud.UsuarioCrudRepository;
import com.jusquer.market.persistence.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    UsuarioCrudRepository usuarioCrudRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = usuarioCrudRepository.findByUsername(username);
        if(usuario.isEmpty()){
            throw new UsernameNotFoundException("El usuario " + username + " no existe");
        }
        return new User(usuario.get().getUsername(),usuario.get().getPassword(), new ArrayList<>());
    }
}
