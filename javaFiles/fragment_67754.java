@Bean
  public FilterRegistrationBean registerBasicAuthFilter(BasicAuthFilter filter) {
      FilterRegistrationBean reg = new FilterRegistrationBean(filter);
      reg.setOrder(Ordered.LOWEST_PRECEDENCE);
      return reg;
  }