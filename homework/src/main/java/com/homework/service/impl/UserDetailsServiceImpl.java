package com.homework.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.homework.model.Role;
import com.homework.model.User;
import com.homework.repository.UserRepository;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Burak Naroglu
 */
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(username);
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		if (user != null) {
			for (Role role : user.getRoles()) {
				grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
			}
			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
					grantedAuthorities);
		} else {
			return null;
		}
	}
}
