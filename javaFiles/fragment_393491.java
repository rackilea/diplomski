public void configure(WebSecurity web) throws Exception {
  web
    .ignoring()
       .antMatchers("/metrics**")
       .antMatchers("/health**")
       .antMatchers("/logfile**")
       .antMatchers("/systemcheck**");
}