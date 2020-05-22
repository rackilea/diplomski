@Override
public void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth
        .ldapAuthentication()
            .userSearchFilter("(sAMAccountName={0})")
            .groupSearchBase("ou=Mutual Ser")
            .contextSource(contextSource());
}