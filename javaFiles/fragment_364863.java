@Override
      public void configure(WebSecurity web) throws Exception {
          web
            .ignoring()
              .antMatchers("/userlogin/")
              .antMatchers("/forgetPassword");
      }