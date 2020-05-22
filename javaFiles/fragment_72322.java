@Autowired
private UserService userService;

@Autowired
private void configureGlobal(AuthenticationManagerBuilder auth)
        throws Exception {

    auth.userDetailsService(userService);
}