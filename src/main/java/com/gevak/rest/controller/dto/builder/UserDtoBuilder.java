package com.gevak.rest.controller.dto.builder;

import com.gevak.rest.controller.dto.UserDTO;
import com.gevak.rest.entity.User;

public class UserDtoBuilder {

    public static UserDTO toDto(User user) {
        return new UserDTO(user.getUsername(), user.getPassword(), user.getEmail());
    }

    public static User toEntity(UserDTO userDTO) {
        return new User(userDTO.username, userDTO.password, userDTO.email);
    }

}
