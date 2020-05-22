@Autowired
public void configureGlobal(AuthenticationManagerBuilder auth)
{
  try 
  {
    auth 
        .inMemoryAuthentication()
          .withUser("admin")
            .password("password")
            .roles("ADMIN");
  } catch (Exception e) {
    e.printStackTrace();
  }
}