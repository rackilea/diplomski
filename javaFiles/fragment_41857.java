@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{
    @Override
    protected void configure(HttpSecurity security) throws Exception
    {
        // Set the security settings
        security.httpBasic().and().authorizeRequests().anyRequest().authenticated().and().csrf();
    }
}