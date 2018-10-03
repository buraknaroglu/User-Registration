package homework.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.homework.model.User;
import com.homework.repository.UserRepository;
import com.homework.service.UserService;
import com.homework.service.impl.UserServiceImpl;
import homework.TestData;
import homework.config.TestContext;
import homework.config.TestWebAppContext;

/**
 * @author Burak Naroglu
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestContext.class, TestWebAppContext.class })
@WebAppConfiguration
public class UserServiceTest {

	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	@Before
	public void init() {
		userService = new UserServiceImpl();
	}

	@Test(expected = NullPointerException.class)
	public void findByUsernameExpectNullPointer() {
		User user = userService.findByUsername(TestData.getUser().getUsername());
		Assert.assertEquals(TestData.getUser().getUsername(), user.getUsername());
	}

}
