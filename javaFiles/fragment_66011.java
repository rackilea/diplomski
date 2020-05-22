@Configuration
@EnableWebFluxSecurity
public class SecurityConfiguration {

    @Bean
    SecurityWebFilterChain springWebFilterChain(ServerHttpSecurity http) {
        return http
            .csrf().disable()
            .authorizeExchange()
                .pathMatchers("/login", "/logout").permitAll()
                .pathMatchers("/i18n/**",
                    "/css/**",
                    "/fonts/**",
                    "/icons-reference/**",
                    "/img/**",
                    "/js/**",
                    "/vendor/**").permitAll()
            .anyExchange()
                .authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .and()
            .logout()
                .logoutUrl("/logout")
                .and()
            .build();
    }


    //in case you want to encrypt password
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}