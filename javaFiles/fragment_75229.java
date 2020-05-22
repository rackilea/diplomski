@Override
        protected void configure(HttpSecurity http) throws Exception{

             http
             .csrf().disable()
             .authorizeRequests().antMatchers("/login").permitAll()
             .antMatchers(HttpMethod.GET,"/actuator/**").permitAll() 
             .antMatchers(HttpMethod.POST,"/actuator/**").permitAll() 
}