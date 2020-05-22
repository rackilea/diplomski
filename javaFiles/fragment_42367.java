@Override
public void contextInitialized(ServletContextEvent contextEvent) {
    try {
        ApplicationContext appContext = WebApplicationContextUtils.getWebApplicationContext(contextEvent.getServletContext());

        // get a bean named "myCalendar" from the application context       
        Calendar cal = (Calendar)appContext.getBean("myCalendar");

        // bind via JNDI
        Context initialContext = new InitialContext();
        Context subCtx = initialContext.createSubcontext("sample");
        subCtx.bind("calendar", cal);

    } catch (NamingException e) { // ommitted }
}