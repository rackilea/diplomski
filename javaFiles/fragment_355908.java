@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = "com.gmail.nlpraveennl")
public class SpringSecurityConfig
{
    @Bean
    public PasswordEncoder passwordEncoder() 
    {
        return new BCryptPasswordEncoder();
    }

    @Configuration
    @Order(1)
    public static class RestApiSecurityConfig extends WebSecurityConfigurerAdapter
    {
        @Autowired
        private JwtAuthenticationTokenFilter jwtauthFilter;

        @Override
        protected void configure(HttpSecurity http) throws Exception
        {
            http
                .csrf().disable()
                .antMatcher("/api/**")
                .authorizeRequests()
                .antMatchers("/api/authenticate").permitAll()
                .antMatchers("/api/**").hasAnyRole("APIUSER")
            .and()
                .addFilterBefore(jwtauthFilter, UsernamePasswordAuthenticationFilter.class);

            http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        }
    }

    @Configuration
    @Order(2)
    public static class LoginFormSecurityConfig extends WebSecurityConfigurerAdapter
    {
        @Autowired
        private PasswordEncoder passwordEncoder;

        @Autowired
        public void configureInMemoryAuthentication(AuthenticationManagerBuilder auth) throws Exception
        {
            auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder.encode("admin@123#")).roles("ADMIN");
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception
        {
            http
                .csrf().disable()
                .antMatcher("/**").authorizeRequests()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/**").hasRole("ADMIN")
            .and().formLogin();

            http.sessionManagement().maximumSessions(1).expiredUrl("/login?expired=true");
        }
    }
}