@Override
public void configure(HttpSecurity http) throws Exception {
    List<Matcher> matchers=matchersService.getAll();
    for(Matcher m : matchers) {
      http.authorizeRequests()
        .antMatchers(m.getMapping())
        .access("#oauth2.hasScope('"+m.getScope()+"')");
    }
}