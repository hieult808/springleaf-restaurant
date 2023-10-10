package com.springleaf_restaurant_backend.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.springleaf_restaurant_backend.user.entities.Major;
import com.springleaf_restaurant_backend.user.entities.Role;
import com.springleaf_restaurant_backend.user.repositories.RoleFunctionRepository;
import com.springleaf_restaurant_backend.user.repositories.RoleRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {
    private final RoleRepository roleRepository;
    private final RoleFunctionRepository roleFunctionRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository, RoleFunctionRepository roleFunctionRepository) {
        this.roleRepository = roleRepository;
        this.roleFunctionRepository = roleFunctionRepository;
    }

    public List<SimpleGrantedAuthority> getAuthorities(Integer roleId) {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        Role role = roleRepository.findById(roleId).orElse(null);
        if (role != null) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }

        List<Major> majors = roleFunctionRepository.findMajorsByRoleId(roleId);
        for (Major major : majors) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + major.getMajorName()));
        }

        return authorities;
    }
}
