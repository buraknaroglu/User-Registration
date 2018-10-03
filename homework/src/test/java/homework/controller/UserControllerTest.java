package homework.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;
import com.homework.controller.UserController;
import com.homework.repository.RoleRepository;
import com.homework.repository.UserRepository;
import com.homework.service.SecurityService;
import com.homework.service.UserService;
import com.homework.validator.UserValidator;
import homework.TestData;
import homework.config.TestContext;
import homework.config.TestWebAppContext;

/**
 * @author Burak Naroglu
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestContext.class, TestWebAppContext.class })
@WebAppConfiguration
public class UserControllerTest {

	@Spy
	@InjectMocks
	private UserController userController;

	@Mock
	private UserService userService;

	@Mock
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Mock
	private RoleRepository roleRepository;

	@Mock
	private UserRepository userRepository;

	@Mock
	private SecurityService securityService;

	@Mock
	private UserValidator userValidator;

	@Mock
	private UserDetailsService userDetailsService;

	@Mock
	private AuthenticationManager authenticationManager;

	private MockHttpServletRequest request;

	private MockHttpServletResponse response;

	private AnnotationMethodHandlerAdapter adapter;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		this.request = new MockHttpServletRequest();
		this.response = new MockHttpServletResponse();
		this.adapter = new AnnotationMethodHandlerAdapter();
	}

	@Test
	public void getRegistration() throws Exception {
		request.setRequestURI("/registration");
		request.setMethod("GET");
		ModelAndView mav = adapter.handle(request, response, userController);
		Assert.assertEquals("registration", mav.getViewName());
	}

	@Test
	public void postRegistration() throws Exception {
		request.setRequestURI("/registration");
		request.setMethod("POST");
		request.setAttribute("userForm", TestData.getUser());
		ModelAndView mav = adapter.handle(request, response, userController);
		Assert.assertEquals("redirect:/welcome", mav.getViewName());
	}

	@Test
	public void getLogin() throws Exception {
		request.setRequestURI("/login");
		request.setMethod("GET");
		ModelAndView mav = adapter.handle(request, response, userController);
		Assert.assertEquals("login", mav.getViewName());
	}

	@Test
	public void getWelcome() throws Exception {
		request.setRequestURI("/");
		request.setMethod("GET");
		ModelAndView mav = adapter.handle(request, response, userController);
		Assert.assertEquals("welcome", mav.getViewName());
	}

	@Test
	public void getWelcomeByWelcomeMapping() throws Exception {
		request.setRequestURI("/welcome");
		request.setMethod("GET");
		ModelAndView mav = adapter.handle(request, response, userController);
		Assert.assertEquals("welcome", mav.getViewName());
	}
}
