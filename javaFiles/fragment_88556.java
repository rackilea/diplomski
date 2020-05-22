@Autowired
public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

    // First encrypt the password string
    String encodedPassword = passwordEncoder().encode("1");

    // Set the password
    UserDetails user = User.builder()
                           .username("1")
                           .password(encodedPassword)
                           .roles("USER")
                           .build();

    // Use in-memory authentication with BCryptEncoder
    auth.inMemoryAuthentication()
        .withUser(user)
        .passwordEncoder(passwordEncoder());
}

@Bean
public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}