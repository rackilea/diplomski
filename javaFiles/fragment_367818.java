@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors()
            .and()

           .csrf().disable().authorizeRequests()
            .antMatchers("/status**", "/topic", "/myapp-websocket/**")
            .permitAll()
            .anyRequest()
            .authenticated();

    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
          CorsConfiguration config = new CorsConfiguration();
          config.setAllowedOrigins(ImmutableList.of("*"));
          config.setAllowCredentials(true);
          config.setAllowedMethods(ImmutableList.of("HEAD",
                    "GET", "POST", "PUT", "DELETE", "PATCH"));
          config.setAllowedHeaders(ImmutableList.of("Authorization", "Cache-Control", "Content-Type"));
           UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            source.registerCorsConfiguration("/**", config);
            return source;
        }
}