package com.service.user.service;

import java.util.UUID;

import com.service.user.dto.UserDTO;

public interface UserService {

  UserDTO getUserById(UUID id);

  UserDTO getUserByEmail(String email);

  UserDTO saveUser(UserDTO user);

  UserDTO updateUser(UserDTO user);

  void deleteUser(UUID id);

}
