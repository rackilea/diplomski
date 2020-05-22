@Autowired
public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception 
{
    auth
        .ldapAuthentication()
            // User Base DN
            .userDnPatterns("cn={0},ou=...,ou=...,o=...,c=...") 
            .contextSource()
                // ldap server
                .url("ldaps://server:636") 
                // Bind credentials Bind DN
                .managerDn("cn=...,ou=...,o=...,c=...") 
                // Bind credentials Bind Password
                .managerPassword("...");
}