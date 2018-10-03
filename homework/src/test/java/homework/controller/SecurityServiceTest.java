package homework.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.homework.service.SecurityService;
import com.homework.service.impl.SecurityServiceImpl;
import homework.config.TestContext;
import homework.config.TestWebAppContext;

/**
 * @author Burak Naroglu
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestContext.class, TestWebAppContext.class})
@WebAppConfiguration
public class SecurityServiceTest {
	
	private SecurityService securityService;
	
	@Before
	public void init() {
		securityService = new SecurityServiceImpl();
	}
	
	@Test(expected = NullPointerException.class)
	public void findLoggedInUsername() {
		String result = securityService.findLoggedInUsername();
		Assert.assertEquals(null, result);
	}

}
