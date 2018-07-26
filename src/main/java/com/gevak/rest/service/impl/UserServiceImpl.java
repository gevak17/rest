package com.gevak.rest.service.impl;

import com.gevak.rest.dao.UserDAO;
import com.gevak.rest.entity.User;
import com.gevak.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public User findOne(Long id) {
        return userDAO.findOne(id);
    }

    @Override
    public void save(User user) {
        userDAO.save(user);
    }
}
