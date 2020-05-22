ldap.urls= ldap://localhost:10389/
ldap.base.dn= dc=example,dc=com
ldap.user.dn.pattern.test1 = cn={0},ou=test1
ldap.user.dn.pattern.test2 = cn={0},ou=test2

@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    if(Boolean.parseBoolean(ldapEnabled)) {
        auth.ldapAuthentication()
                .userDetailsContextMapper(userDetailsContextMapper())
                .userDnPatterns(ldapUserDnPattern1, ldapUserDnPattern2)
                .contextSource()
                .url(ldapUrls+ldapBaseDn);
    }
}