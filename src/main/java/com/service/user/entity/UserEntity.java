package com.service.user.entity;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "person")
public class UserEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private UUID id;
  private String userEmail;
  private String UserPassword;
  private Set<UserRole> userRoles;

  public UserEntity() {
  }

  public UserEntity(UUID id, String userEmail, String userPassword, Set<UserRole> userRoles) {
    this.id = id;
    this.userEmail = userEmail;
    UserPassword = userPassword;
    this.userRoles = userRoles;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getUserEmail() {
    return userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }

  public String getUserPassword() {
    return UserPassword;
  }

  public void setUserPassword(String userPassword) {
    UserPassword = userPassword;
  }

  public Set<UserRole> getUserRoles() {
    return userRoles;
  }

  public void setUserRoles(Set<UserRole> userRoles) {
    this.userRoles = userRoles;
  }

  @Override
  public String toString() {
    return "UserEntity [id=" + id + ", userEmail=" + userEmail + ", UserPassword=" + UserPassword + ", userRoles="
        + userRoles + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((userEmail == null) ? 0 : userEmail.hashCode());
    result = prime * result + ((UserPassword == null) ? 0 : UserPassword.hashCode());
    result = prime * result + ((userRoles == null) ? 0 : userRoles.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    UserEntity other = (UserEntity) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (userEmail == null) {
      if (other.userEmail != null)
        return false;
    } else if (!userEmail.equals(other.userEmail))
      return false;
    if (UserPassword == null) {
      if (other.UserPassword != null)
        return false;
    } else if (!UserPassword.equals(other.UserPassword))
      return false;
    if (userRoles == null) {
      if (other.userRoles != null)
        return false;
    } else if (!userRoles.equals(other.userRoles))
      return false;
    return true;
  }

}