@Override
public void init(ServletConfig config) throws ServletException {
   super.init(config);

   ApplicationContext ac = (ApplicationContext) config.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);

   this.someObject = (SomeBean)ac.getBean("someBeanRef");
}