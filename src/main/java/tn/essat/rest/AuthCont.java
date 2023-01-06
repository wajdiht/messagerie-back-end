package tn.essat.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.essat.Model.User;
import tn.essat.config.GestionToken;
import tn.essat.config.JwtRequest;
import tn.essat.config.JwtResponse;
import tn.essat.service.Userservice;


@CrossOrigin("*") 
@RestController
@RequestMapping(value = "/auth") 
public class AuthCont {
	 @Autowired
	 private GestionToken token_gen; 
	 @Autowired
	 private Userservice userService; 
	 @Autowired
	 private AuthenticationManager authenticationManager; 
	 @PostMapping(value = "/login") 
	 public JwtResponse signIn(@RequestBody JwtRequest request) { 
	 Authentication authentication = authenticationManager.authenticate(new
	UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()) ); 
	 SecurityContextHolder.getContext().setAuthentication(authentication); 
	 User user = (User) userService.loadUserByUsername(request.getUsername()); 
	 String token = token_gen.generateToken(user); 
	 JwtResponse response= new JwtResponse(token); 
	 
	 return response; 
	 } 
	}