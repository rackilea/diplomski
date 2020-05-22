@Override
    public void configure(WebSecurity web) throws Exception {
        web
          .ignoring()
            .antMatchers(HttpMethod.yourMethod, "**/heathCheck/**");
    }