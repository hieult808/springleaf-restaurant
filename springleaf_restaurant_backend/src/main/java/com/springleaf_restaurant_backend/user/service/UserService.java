package com.springleaf_restaurant_backend.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springleaf_restaurant_backend.user.entities.User;
import com.springleaf_restaurant_backend.user.repositories.RoleRepository;
import com.springleaf_restaurant_backend.user.repositories.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (!userOptional.isPresent()) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    
        User user = userOptional.get();
    
        String roleName = roleRepository.findRoleSaByRoleId(user.getRoleId());
        user.setRoleName(roleName);
    
        return user;
    }
    
}
