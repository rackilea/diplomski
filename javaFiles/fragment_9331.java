@Override
public void onStartup(ServletContext servletContext) throws ServletException {

    //...
    WebApplicationContext context = getContext();
    DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
    //we did all this to set the below flag
    dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
    ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet",dispatcherServlet );
    //..
}