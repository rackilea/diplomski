public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter implements InitializingBean {
...
@Autowired
public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
auth
  .authenticationProvider(this.ldapAndDatabaseAuthenticationProvider());
}

@Bean(name="ldapAuthenticationProvider")
public AuthenticationProvider ldapAndDatabaseAuthenticationProvider(){
  LdapUserDetailsMapper userDetailsMapper = new LdapUserDetailsMapper();
  userDetailsMapper.setRoleAttributes(new String[]{"groupMembership"});

  LdapAndDatabaseAuthenticationProvider provider = 
      new LdapAndDatabaseAuthenticationProvider(this.ldapAuthenticator(), this.ldapAuthoritiesPopulator());
  provider.setUserDetailsContextMapper(userDetailsMapper);

  return provider;
}

@Bean( name = "ldapAuthoritiesPopulator" )
public LdapAndDatabaseAuthoritiesPopulator ldapAuthoritiesPopulator(){
  return new LdapAndDatabaseAuthoritiesPopulator(this.contextSource(), "");
}

@Bean( name = "ldapAuthenticator" )
public LdapAuthenticator ldapAuthenticator() {

    BindAuthenticator authenticator = new BindAuthenticator(   this.contextSource() );
  authenticator.setUserDnPatterns(new String[]{"cn={0},ou=prod,o=COMP"});

  return authenticator;
}

@Bean( name = "contextSource" )
public DefaultSpringSecurityContextSource contextSource() {

    DefaultSpringSecurityContextSource contextSource =
          new DefaultSpringSecurityContextSource( ldapUrl );
    return contextSource;
}