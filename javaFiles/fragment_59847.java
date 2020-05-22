@Bean
public CustomAuthenticationFilter customAuthenticationFilter(ObjectMapper mapper) {
    CustomAuthenticationFilter filter = new CustomAuthenticationFilter(mapper);
    filter.setAuthenticationManager(authenticationManagerBean());
    return filter;
}

// To prevent registering the filter in the default filter chain!
@Bean
public FilterRegistrationbean customAuthenticationFilterRegistration() {
    FilterRegistrationBean filterReg = new FilterRegistrationBean(customAuthenticationFilter());
    filterReg.setEnabled(false);
    return filterReg;
}

@Override
public void configure(HttpSecurity http) {

    http.addFilterBefore(customerAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    // other config here
}