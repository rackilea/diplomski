@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Bean
  public SAMLWebSSOHoKProcessingFilter samlFilter() {
    SAMLWebSSOHoKProcessingFilter samlFilter = new SAMLWebSSOHoKProcessingFilter();
    samlFilter.setAuthenticationManage(authenticationManager());
    .......
    return samlFilter;
  }

  @Override  
  protected void configure(HttpSecurity http) throws Exception {
      http.addFilter(samlFilter());
  }
}