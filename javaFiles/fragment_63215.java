@Configuration
@EnableWebSecurity
@Order(1)
public class StatefulConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider).authenticationProvider(secondaryAuthProvider) ;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable().sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED).and()
       .antMatcher("/web/*").authorizeRequests()
                .antMatchers("/*").hasAnyRole("ADMIN","VISITOR").and().
                formLogin().defaultSuccessUrl("/web/login").failureUrl("/web/error").loginPage("/web/login").usernameParameter("username").passwordParameter("password").failureUrl("/").
                and().logout().logoutUrl("/web/logout").permitAll().and().exceptionHandling().accessDeniedPage("/403").and()
                .authorizeRequests().antMatchers("/resources/**").permitAll();
    }

}