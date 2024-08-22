package com.example3.springsecurityjwt.controller;

import com.example3.springsecurityjwt.model.AuthenticationRequest;
import com.example3.springsecurityjwt.model.AuthenticationResponse;
import com.example3.springsecurityjwt.service.MyUserDetailsService;
import com.example3.springsecurityjwt.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtTokenUtil;


    @GetMapping("/hello")
    public String helloMethod()
    {
        return "<h1>Hello world</h1>";
    }

    @RequestMapping(value = "/authenticate",method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken
            (@RequestBody AuthenticationRequest authenticationRequest)
            throws  Exception
    {
        System.out.println(authenticationRequest.getPassword()+"--"+authenticationRequest.getUsername());
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationRequest.getUsername(),
                            authenticationRequest.getPassword()
                    ));
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new Exception("Incorrect username or passowrd",e);
        }
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        System.out.println(userDetails);

        final String jwt =jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));

    }
}
