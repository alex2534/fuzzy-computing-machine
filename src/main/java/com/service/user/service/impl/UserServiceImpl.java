package com.service.user.service.impl;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.service.user.dto.UserDTO;
import com.service.user.entity.UserEntity;
import com.service.user.repository.UserRepository;
import com.service.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  ModelMapper modelMapper = new ModelMapper();

  public UserServiceImpl() {
    this(null);
  }

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  UserDTO userDTO = new UserDTO();

  @Override
  public UserDTO getUserById(UUID id) {
    try {
      if (id != null) {
        UserEntity user = userRepository.findById(id).get();
        userDTO = modelMapper.map(user, UserDTO.class);
      }
    } catch (Exception e) {
      throw new IllegalArgumentException("User not found");
    }
    return userDTO;
  }

  @Override
  public UserDTO getUserByEmail(String email) {

    try {
      if (email != null) {
        // UserEntity user = userRepository.findByUserEmail(email);
        // userDTO = modelMapper.map(user, UserDTO.class);
      }
    } catch (Exception e) {

      throw new IllegalArgumentException("User not found");
    }

    return userDTO;

  }

  @Override
  public UserDTO saveUser(UserDTO user) {

    try {
      if (user != null) {
        UserEntity userEntity = modelMapper.map(user, UserEntity.class);
        UserEntity savedUser = userRepository.save(userEntity);
        userDTO = modelMapper.map(savedUser, UserDTO.class);
      }
    } catch (Exception e) {
      throw new IllegalArgumentException("There was a problem saving the user");
    }
    return userDTO;

  }

  @Override
  public UserDTO updateUser(UserDTO user) {

    try {
      if (user != null) {
        UserEntity userEntity = modelMapper.map(user, UserEntity.class);
        UserEntity savedUser = userRepository.save(userEntity);
        userDTO = modelMapper.map(savedUser, UserDTO.class);
      }
    } catch (Exception e) {
      throw new IllegalArgumentException("There was a problem updating the user");
    }
    return userDTO;
  }

  @Override
  public void deleteUser(UUID id) {

    try {
      if (id != null) {
        UserEntity user = userRepository.findById(id).get();
        userRepository.delete(user);
      }
    } catch (Exception e) {
      throw new IllegalArgumentException("There was a problem deleting the user");
    }
  }

}
