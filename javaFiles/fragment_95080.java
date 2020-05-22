@Bean
public UserDetailsService userDetailsService() {
    // ensure the passwords are encoded properly
    @SuppressWarnings("deprecation")
    UserBuilder users = User.withDefaultPasswordEncoder();
    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
    manager.createUser(users.username("me").password("me").roles("USER").build());
    return manager;
}