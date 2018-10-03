package com.homework.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.homework.model.User;
import com.homework.repository.RoleRepository;
import com.homework.repository.UserRepository;
import com.homework.service.UserService;

/**
 * @author Burak Naroglu
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public void save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(roleRepository.getRoles());
		userRepository.save(user);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUserName(username);
	}
}
