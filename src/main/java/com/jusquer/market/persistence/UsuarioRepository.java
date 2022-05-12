package com.jusquer.market.persistence;

import com.jusquer.market.domain.UserMarket;
import com.jusquer.market.domain.repository.UserMarketRepository;
import com.jusquer.market.persistence.crud.UsuarioCrudRepository;
import com.jusquer.market.persistence.entity.Usuario;
import com.jusquer.market.persistence.mapper.UserMarketMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioRepository implements UserMarketRepository {
    @Autowired
    UsuarioCrudRepository usuarioCrudRepository;

    @Autowired
    UserMarketMapper userMarketMapper;


    @Override
    public UserMarket save(UserMarket userMarket) {
        Usuario usuario = userMarketMapper.toUsuario(userMarket);
        usuario = usuarioCrudRepository.save(usuario);
        return userMarket;
    }
}
