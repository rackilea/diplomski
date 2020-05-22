@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    String [] ignoredPaths = new String[]{
            "/robots.txt", "/error", "/login", "/doLogut", "/home", "/pageNotFound", 
            "/css/**", "/js/**", "/fonts/**", "/img/**", ...
    };

    @Override
    public void configure(HttpSecurity http) throws Exception{

        http.authorizeRequests()
            .antMatchers(ignoredPaths).permitAll()
            .anyRequest().authenticated()
        .and()
            .httpBasic();   
    }