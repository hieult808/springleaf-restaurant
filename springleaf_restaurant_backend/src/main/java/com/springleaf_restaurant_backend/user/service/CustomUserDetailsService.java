// package com.springleaf_restaurant_backend.user.service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
// import org.springframework.security.provisioning.UserDetailsManager;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class CustomUserDetailsService implements UserDetailsService {
//     private final RoleService roleService;

//     @Autowired
//     public CustomUserDetailsService(RoleService roleService) {
//         this.roleService = roleService;
//     }

//     @Override
//     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
//         if ("admin".equals(username)) {
//             List<SimpleGrantedAuthority> authorities = roleService.getAuthorities(1); // Thay 1 bằng roleId thích hợp cho admin
//             return User.builder()
//                     .username(username)
//                     .password("{bcrypt}$2a$10$9pZz5LhzD8otyUxXNFSPr.HKRgDNi1mYmWUsBunX7i/UOHVV1U2wW") // Mật khẩu đã mã hóa
//                     .authorities(authorities)
//                     .build();
//         } else {
//             throw new UsernameNotFoundException("User not found!");
//         }
//     }
// }
