@Override
public void configure(HttpSecurity http) throws Exception {
    http
    .requestMatchers()
    .antMatchers("/api/**")
    .and()
    .authorizeRequests()
    .antMatchers("/api/books/*").anonymous();
}