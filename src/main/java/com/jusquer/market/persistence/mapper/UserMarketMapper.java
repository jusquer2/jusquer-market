package com.jusquer.market.persistence.mapper;

import com.jusquer.market.domain.UserMarket;
import com.jusquer.market.persistence.entity.Usuario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
@Mapper(componentModel = "spring")
public interface UserMarketMapper {
    @Mappings({
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "username", target = "user"),
            @Mapping(source = "password", target = "password")
    })
    UserMarket toUserMarket(Usuario usuario);

    @InheritInverseConfiguration
    Usuario toUsuario(UserMarket userMarket);
}
