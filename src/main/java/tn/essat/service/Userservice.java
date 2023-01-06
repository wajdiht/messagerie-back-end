package tn.essat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import tn.essat.dao.IUser;

@Service
public class Userservice implements UserDetailsService{
	@Autowired
	IUser userDao;

	@Bean
	private PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder();     }
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return userDao.findByUsername(username);
	}
    
	
	
	
	
	
}
