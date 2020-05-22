public static ApplicationConfig getCurrentInstance(ServletContext sctx) {
  if (sctx == null) {
    throw new AssertionError("ServletContext is null");
  }
  WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(sctx);
  if (wac == null) {
    throw new AssertionError("No ApplicationContext associated with ServletContext");
  }
  return (ApplicationConfig) wac.getBean("myAppConfigs");
}