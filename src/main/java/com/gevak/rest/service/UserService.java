package com.gevak.rest.service;

import com.gevak.rest.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findOne(Long id);

    void save(User user);


}
