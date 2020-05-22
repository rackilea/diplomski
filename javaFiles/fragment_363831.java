@Configuration
@EnableResourceServer
public class ResourceServerConfiguration implements ResourceServerConfigurer {

    @Override
    public void configure(ResourceServerSecurityConfigurer security) throws Exception {
        security.stateless(false);
    }

    @Override
    public void configure(HttpSecurity http) {}

}