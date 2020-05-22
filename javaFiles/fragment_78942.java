public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

  @Override
  protected void customizeRegistration(ServletRegistration.Dynamic registration) {
      registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");
  }

  @Override
  protected Class<?>[] getRootConfigClasses() {
      return new Class[] {PersistenceConfiguration.class}
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
      throw new Class[] {MvcConfiguration.class};
  }

  @Override
  protected String[] getServletMappings() {
    return new String[] {"/"};
  }

  protected Filter[] getServletFilters() {
    return return new Filter[] {new OpenentityManagerInViewFilter()};
  }

}