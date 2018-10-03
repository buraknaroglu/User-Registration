package com.homework.service;

/**
 * @author Burak Naroglu
 */
public interface SecurityService {

	String findLoggedInUsername();

	void autologin(String username, String password);
}
