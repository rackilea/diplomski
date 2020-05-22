@Override
protected void configure(AuthenticationManagerBuilder
authManagerBuilder) throws Exception {
...
.userDetailsService(userDetailsService());
...
}