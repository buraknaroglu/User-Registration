package com.homework.repository;

import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Repository;
import com.homework.model.User;

/**
 * @author Burak Naroglu
 */
@Repository
public class UserRepository {

	Set<User> users = new HashSet<>();

	public void save(User user) {
		users.add(user);
	}

	public User findByUserName(String username) {
		return users.stream().filter(user -> user.getUsername().equals(username)).findFirst().orElse(null);
	}
}
