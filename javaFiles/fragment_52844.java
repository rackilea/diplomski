@Autowired
private CustomUserDetailsService customUserDetailsService;

@Autowired
public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService);
}