@EnableWebSecurity
@Configuration
public class CustomWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

      @Override
      protected void configure(HttpSecurity http) throws Exception {
        http
          .authorizeUrls()
            .antMatchers("/admin/**").hasRole("ADMIN")
            .antMatchers("/**").access("hasIpAddress('127.0.0.1/24')")
            .anyRequest().authenticated();

      }
    }