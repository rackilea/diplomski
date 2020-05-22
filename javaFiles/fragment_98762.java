@Override
protected UserDetails retrieveUser(final String username, final UsernamePasswordAuthenticationToken authentication) {

    System.out.println("Verification: "+authentication.getPrincipal()+" => "+authentication.getCredentials());

    final Object token = authentication.getCredentials();
    final String ipAddress= Optional
            .ofNullable(authentication.getPrincipal())
            .map(String::valueOf)
            .orElse("");

    return Optional
            .ofNullable(token)
            .map(String::valueOf)
            .flatMap(auth::findByToken)
            .filter(user -> user.ipAddress.equals(ipAddress))   // weryfikacja adresu ip
            .orElseThrow(() -> new UsernameNotFoundException("Cannot find user with authentication token=" + token));
}