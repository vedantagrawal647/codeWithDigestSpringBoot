package com.example3.springsecurityjpa.config;

import com.example3.springsecurityjpa.Repository.UserRepository;
import com.example3.springsecurityjpa.model.MyUserDetails;
import com.example3.springsecurityjpa.model.UserTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

         Optional<UserTable> user = userRepository.findByUserName(username);
         user.orElseThrow(() -> new UsernameNotFoundException("Now Found : " + username));

         return user.map(MyUserDetails::new).get();
    }
}
