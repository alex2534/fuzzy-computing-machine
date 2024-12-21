package com.service.user.controller;

import java.util.UUID;

import com.service.user.dto.UserDTO;

public interface UserController {

  UserDTO saveUser(UserDTO user);

  UserDTO updateUser(UserDTO user);

  UserDTO getUserById(UUID id);

  UserDTO getUserByEmail(String email);

  void deleteUser(UUID id);

}
