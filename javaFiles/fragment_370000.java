package com.test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UrlPathHelper;

@SpringBootApplication
public class TestSpringSecurityCustomApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestSpringSecurityCustomApplication.class, args);
    }
}

@Configuration
class CustomWebSecurity extends WebSecurityConfigurerAdapter {
    @Autowired
    private JWTAuthenticationFilter jwtAuthenticationFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("Configuring security");

        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
            .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
            .authorizeRequests()
                .anyRequest().authenticated()
            .and().csrf().disable();
    }

    @Override
    public void configure(WebSecurity web)
            throws Exception {
        web.ignoring().antMatchers("/login/**", "/signup/**");
    }
    /* Stopping spring from adding filter by default */
    @Bean
    public FilterRegistrationBean rolesAuthenticationFilterRegistrationDisable(JWTAuthenticationFilter filter) {
        FilterRegistrationBean registration = new FilterRegistrationBean(filter);
        registration.setEnabled(false);
        return registration;
    }
}

@RestController
@RequestMapping("greeting")
class TestService {
    @RequestMapping("test")
    public String test() {
        return "Hello World " + new Date();
    }
}

@Component
class JWTAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    @Autowired
    private UserDetailsService customUserDetailsService;

    private static Logger logger = LoggerFactory.getLogger(JWTAuthenticationFilter.class);
    private final static UrlPathHelper urlPathHelper = new UrlPathHelper();

    public JWTAuthenticationFilter() {
        super("/**");
        setAuthenticationManager(new NoOpAuthenticationManager());
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {
        Authentication authentication = AuthenticationService.getAuthentication(request, customUserDetailsService);
        return getAuthenticationManager().authenticate(authentication);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
            Authentication authResult) throws IOException, ServletException {
        SecurityContextHolder.getContext().setAuthentication(authResult);

        chain.doFilter(request, response);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException failed) throws IOException, ServletException {
        logger.debug("failed authentication while attempting to access "
                + urlPathHelper.getPathWithinApplication((HttpServletRequest) request));

        //Add more descriptive message
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
                "Authentication Failed");
    }
}

class AuthenticationService {
    public static Authentication getAuthentication(HttpServletRequest request, UserDetailsService userDetailsService) {

        String username = "TEST_USER";// get this from the token or request

        UserDetails user = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user,
                user.getPassword(), user.getAuthorities());

        //Use following to indicate that authentication failed, if user not found or role doesn't match
        boolean hasAuthenticationFailed = false;

        if(hasAuthenticationFailed) {
            throw new AuthenticationException(username){};
        }

        return authentication;
    }
}

@Component
class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Returning dummy user, use your own logic for example load from
        // database
        List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority(("ROLE_USER")));
        User user = new User("TEST_USER", "NO_PASSWORD", authorities);

        System.out.println("user : " + user.getUsername());

        return user;
    }
}

class NoOpAuthenticationManager implements AuthenticationManager {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return authentication;
    }

}