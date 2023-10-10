package com.springleaf_restaurant_backend.user.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springleaf_restaurant_backend.user.entities.Major;
import com.springleaf_restaurant_backend.user.entities.RoleFunction;

public interface RoleFunctionRepository extends JpaRepository<RoleFunction, String> {
    List<Major> findMajorNameByRoleId(Integer roleId);

    List<Major> findMajorsByRoleId(Integer roleId);
}
