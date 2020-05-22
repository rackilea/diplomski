@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

...


        @Override
        public void init(AuthenticationManagerBuilder auth) throws Exception {
            String ldapURI = "ldap://" + ldaHost + ":" + ldapPort + "/" + ldapBasis;

            DefaultSpringSecurityContextSource contextSource = new DefaultSpringSecurityContextSource(ldapURI);
            contextSource.setUserDn(ldapUser);
            contextSource.setPassword(ldapPassword);
            contextSource.afterPropertiesSet();

            LdapAuthenticationProviderConfigurer<AuthenticationManagerBuilder> ldapAuthenticationProviderConfigurer = auth
                    .ldapAuthentication().userDetailsContextMapper(userDetailsContextMapper());

            ldapAuthenticationProviderConfigurer
                    .userSearchFilter("(&(criteria={0}))")
                    .userSearchBase("ou=usersearchbase").contextSource(contextSource);
        }
    @Bean
    public LdapUserDetailsContextMapper userDetailsContextMapper() {
        return new LdapUserDetailsContextMapper();
    }
}