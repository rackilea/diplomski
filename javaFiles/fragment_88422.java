@Configuration
@EnableWebSecurity
@Order(Ordered.HIGHEST_PRECEDENCE)
public static class ApiSecurity extends WebSecurityConfigurerAdapter{

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.antMatcher("/api/**");
            //continue configure http ......
        }

}