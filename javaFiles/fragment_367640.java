@EnableWebSecurity
    @Configuration
    public class BasicSecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {
         http.authorizeRequests().antMatchers("/baseUrl/anything-else/**").hasIpAddress("ipAddressExpression")
    }
}