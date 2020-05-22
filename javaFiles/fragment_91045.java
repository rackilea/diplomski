public void contextDestroyed(ServletContextEvent event) {
    HibernateUtil.getSessionFactory().close(); // Free all resources
    try {
          DriverManager.getConnection("jdbc:derby:;shutdown=true");
    } catch (SQLException e) {}
    }
}