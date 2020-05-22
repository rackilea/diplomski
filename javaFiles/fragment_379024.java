@Override
public void init(ServletConfig config) throws ServletException {
   super.init(config);

   ApplicationContext ac = (ApplicationContext) config.getServletContext().getAttribute("applicationContext");

   this.apiData = (ApiData)ac.getBean("apiData");
   this.apiLogger = (ApiLogger)ac.getBean("apiLogger");
}