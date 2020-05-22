@Configuration
@EnableWebSecurity
public class SecSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
          .authorizeRequests()
          .antMatchers("/allStudents").hasRole("ROLE_ADMIN"); // assuming this is your endpoint/controller for allStudents.jsp page
    }
}