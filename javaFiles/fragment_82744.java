@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    String[] ignoredPaths = new String[]{...};

    @Override
    public void configure(HttpSecurity http) throws Exception{

        http.authorizeRequests()
            .antMatchers(ignoredPaths).permitAll()
            .anyRequest().authenticated()
        .and()
            .httpBasic();   
    }