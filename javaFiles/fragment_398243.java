public class ServletContextClass implements ServletContextListener
{
    public static Connection con;

    public void contextInitialized(ServletContextEvent arg0) 
    {
        con.getInstance ();     
    }//end contextInitialized method

    public void contextDestroyed(ServletContextEvent arg0) 
    {
        con.close ();       
    }//end constextDestroyed method
}