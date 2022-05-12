package com.jusquer.market.web.controller;

import com.jusquer.market.domain.UserMarket;
import com.jusquer.market.domain.dto.AuthenticationRequest;
import com.jusquer.market.domain.dto.AuthenticationResponse;
import com.jusquer.market.domain.service.UserMarketService;
import com.jusquer.market.web.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private UserMarketService userMarketService;

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody UserMarket userMarket){
        UserMarket us = new UserMarket(userMarket.getName(),passwordEncoder.encode(userMarket.getPassword()),userMarket.getUser());
        userMarketService.save(us);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> createToken(@RequestBody AuthenticationRequest authenticationRequest){
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
            UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
            String jwt = jwtUtil.generateToken(userDetails);

            return new ResponseEntity<>(new AuthenticationResponse(jwt),HttpStatus.OK);
        }catch(BadCredentialsException ex){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

    }
}
