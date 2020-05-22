@Autowired
public void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(authenticationProviderWithEncryptedUser);
    auth.authenticationProvider(authenticationProviderWithNonEncryptedUser);

}