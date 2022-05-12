package com.jusquer.market.domain.service;

import com.jusquer.market.domain.UserMarket;
import com.jusquer.market.domain.repository.UserMarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMarketService implements UserMarketRepository {

    @Autowired
    UserMarketRepository userMarketRepository;

    @Override
    public UserMarket save(UserMarket userMarket) {
        return userMarketRepository.save(userMarket);
    }
}
