package com.service.user.controller.impl;

import java.util.UUID;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.user.controller.UserController;
import com.service.user.dto.UserDTO;
import com.service.user.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/users")
public class UserControllerImpl implements UserController {

  private final UserServiceImpl userService;

  public UserControllerImpl(UserServiceImpl userService) {
    this.userService = userService;
  }

  UserDTO userDTO = new UserDTO();

  @GetMapping("/hello")
  public String getAllUsers(@RequestParam(required = true, defaultValue = "World") String name) {
    System.err.println("******************************" + name);
    System.out.println("Hello World");
    System.out.println("***************************************");

    return "Hello World";
  }

  @Override
  @PostMapping
  public UserDTO saveUser(UserDTO user) {
    try {
      if (user != null) {
        userDTO = userService.saveUser(user);
      }
    } catch (Exception e) {
      throw new IllegalArgumentException("There was a problem saving the user");
    }
    return userDTO;

  }

  @Override
  @PutMapping("/update/{id}")
  public UserDTO updateUser(UserDTO user) {

    try {
      if (user != null) {
        userDTO = userService.updateUser(user);
      }
    } catch (Exception e) {
      throw new IllegalArgumentException("There was a problem updating the user");
    }
    return userDTO;
  }

  @Override
  @GetMapping("/id/{id}")
  public UserDTO getUserById(UUID id) {

    try {
      if (id != null) {
        userDTO = userService.getUserById(id);
      }
    } catch (Exception e) {
      throw new IllegalArgumentException("User not found");
    }
    return userDTO;
  }

  @Override
  @GetMapping("/email/{email}")
  public UserDTO getUserByEmail(String email) {

    try {
      if (email != null) {
        userDTO = userService.getUserByEmail(email);
      }
    } catch (Exception e) {
      throw new IllegalArgumentException("User not found");
    }
    return userDTO;
  }

  @Override
  @DeleteMapping("/delete/{id}")
  public void deleteUser(UUID id) {

    try {
      if (id != null) {
        userService.deleteUser(id);
      }
    } catch (Exception e) {
      throw new IllegalArgumentException("There was a problem deleting the user");
    }
  }

}
