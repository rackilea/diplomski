@Configuration
@EnableWebSecurity
public void WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

  public void configure(HttpSecurity http) { ... // Security config here}

  @Bean
  public CustomAuthenticationProvider customProvider() {
    return new CustomAuthenticationProvider();
  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(customProvider());
  }

}