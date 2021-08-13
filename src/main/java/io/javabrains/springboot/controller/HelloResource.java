package io.javabrains.springboot.controller;

import io.javabrains.springboot.model.AuthenticarionRequest;
import io.javabrains.springboot.model.AutheticationResponse;
import io.javabrains.springboot.security.util.JWTUtil;
import io.javabrains.springboot.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloResource {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping("/hello")
    public ResponseEntity hello() {
        return ResponseEntity.ok("Hello World!!");
    }


    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<AutheticationResponse> authenticate(@RequestBody AuthenticarionRequest request) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(request.getUserName());

        return ResponseEntity.ok(new AutheticationResponse(jwtUtil.generateToken(userDetails)));
    }
}
