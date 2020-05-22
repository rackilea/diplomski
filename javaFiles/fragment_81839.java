@Override
protected void configure(final HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
            .antMatchers("/saml*").permitAll()
            .anyRequest().authenticated()
            .and()
        .apply(saml())
            .webSSOProfileConsumer(getWebSSOProfileConsumerImpl())// <= here
            // ... rest of the setup

}


public WebSSOProfileConsumerImpl getWebSSOProfileConsumerImpl() {
    WebSSOProfileConsumerImpl profileConsumer = new WebSSOProfileConsumerImpl();
    profileConsumer.setMaxAuthenticationAge(5000);
    return profileConsumer;
}