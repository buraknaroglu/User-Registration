package com.homework.service;

import com.homework.model.User;

/**
 * @author Burak Naroglu
 */
public interface UserService {

	void save(User user);

	User findByUsername(String username);
}
