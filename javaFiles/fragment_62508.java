@Configuration
@EnableResourceServer
class MyResourceServerConfigurerAdapter(
        val userDetailsService: MyUserDetailsService
) : ResourceServerConfigurerAdapter() {
    private val passwordEncoder = BCryptPasswordEncoder()

    override fun configure(http: HttpSecurity?) {
        http!!
                .authenticationProvider(authenticationProvider())
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .csrf().disable()
    }

    @Bean
    fun authenticationProvider() : AuthenticationProvider {
        val authProvider = DaoAuthenticationProvider()
        authProvider.setUserDetailsService(userDetailsService)
        authProvider.setPasswordEncoder(passwordEncoder)
        return authProvider
    }
}