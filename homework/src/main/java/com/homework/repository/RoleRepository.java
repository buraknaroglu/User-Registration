package com.homework.repository;

import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Component;
import com.homework.model.Role;

/**
 * @author Burak Naroglu
 */
@Component
public class RoleRepository {

	public Set<Role> getRoles() {
		Set<Role> roles = new HashSet<>();
		roles.add(new Role("ROLE_USER"));
		return roles;
	}
}
