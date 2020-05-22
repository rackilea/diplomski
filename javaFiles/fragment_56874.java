public class MyServletContextListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent sc) {

    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        // load the properties file if needed
        // read the path from web.xml as init parameter 

        Map<String, String> map = new HashMap<String, String>();
        map.put("urlOfThisPage", sc.getInitParameter("urlOfThisPage"));
        map.put("urlOfThatPage", sc.getInitParameter("urlOfThatPage"));

        sc.setAttribute("map", map);
    }

}