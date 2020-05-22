@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration
{
    @Bean
    public PasswordEncoder passwordEncoder() 
    {
        return new BCryptPasswordEncoder();
    }

    @Configuration
    @Order(1)
    public static class BasicAuthSecurityConfig extends WebSecurityConfigurerAdapter
    {
        @Autowired
        private PasswordEncoder passwordEncoder;

        @Autowired
        public void configureInMemoryAuthentication(AuthenticationManagerBuilder auth) throws Exception
        {
            auth.inMemoryAuthentication()
                    .withUser("superadmin")
                    .password(passwordEncoder.encode("superadmin@123#"))
                    .roles("SUPER_ADMIN");
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception
        {
            http.csrf().disable()
                .antMatcher("/rest/**")
                    .authorizeRequests()
                .antMatchers("/rest/**").hasRole("SUPER_ADMIN")
            .and().httpBasic();

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
            auth.inMemoryAuthentication()
                    .withUser("user")
                    .password(passwordEncoder.encode("user@123#"))
                    .roles("USER");
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception
        {
            http
                .antMatcher("/**") //wild card i.e, allow all (But already /rest/** is filtered by 1st config)
                    .authorizeRequests()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/**").authenticated()
            .and().formLogin()
                .defaultSuccessUrl("/app/user/dashboard")
            .and().exceptionHandling()
                .accessDeniedPage("/403")
            .and().logout()
                .invalidateHttpSession(true);

            http.sessionManagement().maximumSessions(1).expiredUrl("/login?expired");
        }
    }
}