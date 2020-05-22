@Autowired
private AuthenticationProvider authenticationProvider;

@Autowired
@Qualifier("preAuthProvider")
private AuthenticationProvider preAuthProvider;

@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(authenticationProvider).authenticationProvider(preAuthProvider);
}