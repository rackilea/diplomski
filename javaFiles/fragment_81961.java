@SpringBootApplication
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {


@Override
public void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth
      .ldapAuthentication()
        .userDnPatterns("uid={0},ou=people")
        .groupSearchBase("ou=groups")
        .contextSource()
        .url("ldap://localhost:8389/dc=springframework,dc=org")
        .and()
        .userDetailsContextMapper(new InetOrgPersonContextMapper())
        .passwordCompare()
        .passwordEncoder(passwordEncoder())
        .passwordAttribute("userPassword");
}