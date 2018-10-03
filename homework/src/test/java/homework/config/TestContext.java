package homework.config;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.homework.controller.UserController;
import com.homework.repository.RoleRepository;
import com.homework.repository.UserRepository;
import com.homework.service.SecurityService;
import com.homework.service.UserService;
import com.homework.validator.UserValidator;

/**
 * @author Burak Naroglu
 */
@Configuration
public class TestContext {

    @Bean
    public UserController userController() {
        return Mockito.mock(UserController.class);
    }
    
    @Bean
    public UserService userService() {
    	return Mockito.mock(UserService.class);
    }
    
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
    	return Mockito.mock(BCryptPasswordEncoder.class);
    }
    
    @Bean
    public UserRepository userRepository() {
    	return Mockito.mock(UserRepository.class);
    }
    
    @Bean
    public RoleRepository roleRepository() {
    	return Mockito.mock(RoleRepository.class);
    }
    
    @Bean
    public SecurityService securityService() {
    	return Mockito.mock(SecurityService.class);
    }
    
    @Bean
    public UserValidator userValidator() {
    	return Mockito.mock(UserValidator.class);
    }
    
    @Bean
    public UserDetailsService userDetailsService() {
    	return Mockito.mock(UserDetailsService.class);
    }
    
    @Bean
    public AuthenticationManager authenticationManager() {
    	return Mockito.mock(AuthenticationManager.class);
    }

}
