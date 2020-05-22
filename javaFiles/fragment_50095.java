@Autowired
public void configureInMemoryAuthentication(AuthenticationManagerBuilder auth) throws Exception
{
    auth.inMemoryAuthentication()
    .withUser("restapiuser")
    .password(new BCryptPasswordEncoder().encode("restapiuser@123#"))
    .roles("APIUSER");
}