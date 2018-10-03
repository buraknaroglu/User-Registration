package com.homework.validator;

import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.homework.model.User;

/**
 * @author Burak Naroglu
 */
@Component
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> aClass) {
		return User.class.equals(aClass);
	}

	@Override
	public void validate(Object o, Errors errors) {
		User user = (User) o;

		if (StringUtils.isBlank(user.getUsername())) {
			errors.rejectValue("username", "empty");
			return;
		}

		if (!validateUserNameByRegex(user.getUsername())) {
			errors.rejectValue("username", "username.error");
			return;
		}

		if (StringUtils.isBlank(user.getEmail())) {
			errors.rejectValue("email", "empty");
			return;
		}

		if (!validateEmailByRegex(user.getEmail())) {
			errors.rejectValue("email", "email.error");
			return;
		}

		if (StringUtils.isBlank(user.getPassword())) {
			errors.rejectValue("password", "empty");
			return;
		}

		if (!validatePasswordByRegex(user.getPassword())) {
			errors.rejectValue("password", "password.error");
			return;
		}

		if (StringUtils.isBlank(user.getPasswordConfirm())) {
			errors.rejectValue("passwordConfirm", "empty");
			return;
		}

		if (!user.getPasswordConfirm().equals(user.getPassword())) {
			errors.rejectValue("passwordConfirm", "passwordConfirm.error");
			return;
		}
	}

	public boolean validateEmailByRegex(String email) {
		try {
			if (StringUtils.isEmpty(email)) {
				return false;
			}
			String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
					+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
			Pattern pattern = Pattern.compile(EMAIL_PATTERN);
			return pattern.matcher(email).matches();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean validateUserNameByRegex(String username) {
		try {
			if (StringUtils.isEmpty(username)) {
				return false;
			}
			String USERNAME_PATTERN = "(.*[a-z]){3}";
			Pattern pattern = Pattern.compile(USERNAME_PATTERN);
			return pattern.matcher(username).matches();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean validatePasswordByRegex(String password) {
		try {
			if (StringUtils.isEmpty(password)) {
				return false;
			}
			String PASSWORD_PATTERN = "^(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{7,}$";
			Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
			return pattern.matcher(password).matches();
		} catch (Exception e) {
			return false;
		}
	}
}
