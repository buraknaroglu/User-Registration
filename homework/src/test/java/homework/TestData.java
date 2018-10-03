package homework;

import java.util.HashSet;
import java.util.Set;
import com.homework.model.Role;
import com.homework.model.User;

/**
 * @author Burak Naroglu
 */
public class TestData {

	public static User getUser() {
		User user = new User();
		user.setEmail("burak26.homework@gmail.com");
		user.setUsername("burak");
		user.setPassword("Test1234");
		user.setPasswordConfirm("Test1234");
		Set<Role> roles = new HashSet<>();
		roles.add(getRole());
		user.setRoles(roles);
		return user;
	}

	public static Role getRole() {
		Role role = new Role();
		role.setName("ROLE_USER");
		return role;
	}
}
