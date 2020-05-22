@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = "com.gmail.nlpraveennl")
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter
{
    @Autowired
    private JwtAuthenticationTokenFilter jwtauthFilter;

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
            .antMatchers("/api/authenticate").permitAll()
            .antMatchers("/api/**").hasAnyRole("APIUSER","ADMIN")
            .antMatchers("/**").hasRole("ADMIN")
        .and()
            .formLogin()
        .and()
            .addFilterBefore(jwtauthFilter, UsernamePasswordAuthenticationFilter.class);

        http.sessionManagement().maximumSessions(1).expiredUrl("/login?expired=true");
    }

    @Bean
    public PasswordEncoder passwordEncoder() 
    {
        return new BCryptPasswordEncoder();
    }
}