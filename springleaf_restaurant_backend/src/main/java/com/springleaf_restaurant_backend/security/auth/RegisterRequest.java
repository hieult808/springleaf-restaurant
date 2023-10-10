package com.springleaf_restaurant_backend.security.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
  private String firstName;
  private String lastName;
  private String userName;
  private String password;
  private String phone;
  private String email;
  private String address;
  private String image;
  private String manager_id;
  private String restaurant_id;
  private Integer roleId;
}
