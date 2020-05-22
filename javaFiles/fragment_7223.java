//By default this filter order is 100 and OAuth has filter order 3
      @Order(2)
    public class MicroserviceSecurityConfigurationHttpBasic extends  WebSecurityConfigurerAdapter { 
          @Override
          protected void configure(HttpSecurity http) throws Exception {
             http.csrf().disable().exceptionHandling()
            .authenticationEntryPoint(customAccessDeniedHandler())
            .and().headers().frameOptions().disable()
            .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .requestMatcher(new BasicRequestMatcher())
            .authorizeRequests()
            .antMatchers("/api/**").authenticated()
            .and().httpBasic();

          }
          private class BasicRequestMatcher implements RequestMatcher {
            @Override
            public boolean matches(HttpServletRequest httpRequest) {
             String auth = httpRequest.getHeader("Authorization");
             String requestUri = httpRequest.getRequestURI();
             //Fetching Identifier to provide OAuth Security to only specific urls
             String identifier= requestUri.substring(requestUri.lastIndexOf("/") + 1, requestUri.length());

            //Lets say for identifier ABC only, I want to secure it using OAuth2.0
           if (auth != null && auth.startsWith("Basic") && identifier.equalsIgnoreCase("ABC")) {
             auth=null;
              }
           //For ABC identifier this method will return null so then the authentication will be redirected to OAuth2.0 config.
           return (auth != null && auth.startsWith("Basic"));
            }
        }
  }