public class ServerConfig extends WebMvcConfigurationSupport {
  @Bean
  public FilterRegistrationBean<GenericExceptionHandlerFilter> genericExceptionFilter() {
    FilterRegistrationBean<GenericExceptionHandlerFilter> registration = new FilterRegistrationBean<>();
    GenericExceptionHandlerFilter genericExceptionHandlerFilter = new GenericExceptionHandlerFilter(
        httpResponseMapper(), getMessageConverters());
    registration.setFilter(genericExceptionHandlerFilter);
    registration.setOrder(FiltersOrder.GENERIC_EXCEPTION_HANDLER);
    return registration;
  }
}