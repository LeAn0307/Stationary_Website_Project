package com.shinhands.mu.Stationary.service;

import com.shinhands.mu.Stationary.dto.UserDTO;

import java.util.List;

public interface UserService {
    public List<UserDTO> getAllUsers();
    public Boolean addUser(UserDTO userDTO);
    public Boolean deleteUser(long id);
    public UserDTO getUserById(long id);
    public Boolean updateUser(long id, UserDTO userDTO);

    public Boolean checkAdmin(String email, String password);

    public UserDTO getUserByAccount(String email, String password);
}
