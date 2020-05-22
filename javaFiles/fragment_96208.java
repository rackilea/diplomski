public class AppServletContextListener implements ServletContextListener{
      public void contextInitialized(ServletContextEvent event)
      {
            ServletContext context=event.getServletContext();
            String url=context.getInitParameter("db-URL");
            String username=context.getInitParameter("db-Username");
            String password=context.getInitParameter("db-Password");
            DbManager mydb=new DbManager(url,username,password);
            context.setAttribute("Database", mydb);

      }
      public void contextDestroyed(ServletContextEvent event)
      {
           ServletContext context = event.getServletContext();
           context.removeAttribute("Database");
      }
}