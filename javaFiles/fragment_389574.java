@Autowired
@Qualifier("myuserdet")
UserDetailsService userDetailsService;
protected void init(AuthenticationManagerBuilder auth) throws Exception {
    System.out.println("I'm here");
    auth.authenticationProvider(authProvider());
}

@Bean
public DaoAuthenticationProvider authProvider() {
    System.out.println("got here");
    DaoAuthenticationProvider authProvider = new 
   DaoAuthenticationProvider();
    authProvider.setUserDetailsService(userDetailsService);
    authProvider.setPasswordEncoder(passwordEncoder());
    return authProvider;
}