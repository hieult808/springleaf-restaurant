package com.springleaf_restaurant_backend.user.entities;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.springleaf_restaurant_backend.user.repositories.MajorRepository;
import com.springleaf_restaurant_backend.user.repositories.RoleFunctionRepository;
import com.springleaf_restaurant_backend.user.repositories.RoleRepository;

import jakarta.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "role_sa")
    private String role_sa;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "role_detail")
    private String roleDetail;

    @Column(name = "description")
    private String description;

    // public List<SimpleGrantedAuthority> getAuthorities() {
    //     List<Major> majors = roleFunctionRepository.findMajorNameByRoleId(roleId);
    //     List<SimpleGrantedAuthority> authorities = new ArrayList<>();

    // for (Major major : majors) {
    //     authorities.add(new SimpleGrantedAuthority(major.getMajorName()));
    // }
    // authorities.add(new SimpleGrantedAuthority("ROLE_" + getRoleName()));

    // return authorities;
    // }

    // public List<SimpleGrantedAuthority> getAuthorities2() {
    //     List<SimpleGrantedAuthority> authorities = new ArrayList<>();
    
    //     // Lấy danh sách các Major có quan hệ với vai trò (role) của người dùng
    //     List<Major> majors = roleFunctionRepository.findMajorsByRoleId(roleId);
    
    //     // Thêm quyền ROLE_<role_name> vào danh sách authorities
    //     authorities.add(new SimpleGrantedAuthority(roleName)); 
    
    //     // Thêm quyền ROLE_<major_name> vào danh sách authorities cho mỗi Major
    //     for (Major major : majors) {
    //         authorities.add(new SimpleGrantedAuthority("ROLE_" + major.getMajorName()));
    //     }
    
    //     return authorities;
    // }
    

}
