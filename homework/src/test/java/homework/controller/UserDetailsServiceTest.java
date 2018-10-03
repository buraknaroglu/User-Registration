package homework.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.homework.repository.UserRepository;
import com.homework.service.impl.UserDetailsServiceImpl;
import homework.TestData;
import homework.config.TestContext;
import homework.config.TestWebAppContext;

/**
 * @author Burak Naroglu
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestContext.class, TestWebAppContext.class })
@WebAppConfiguration
public class UserDetailsServiceTest {

	private UserDetailsService userDetailsService;

	@Mock
	private UserRepository userRepository;

	@Before
	public void init() {
		userDetailsService = new UserDetailsServiceImpl();
	}

	@Test(expected = NullPointerException.class)
	public void loadUserByUsernameExpectNullPointer() {
		UserDetails result = userDetailsService.loadUserByUsername(TestData.getUser().getUsername());
		Assert.assertEquals(TestData.getUser().getUsername(), result.getUsername());
	}

}
