public void contextInitialized(ServletContextEvent sce) {
    WebAppContext ctx = (WebAppContext) sce.getServletContext();
    System.out.println("context Base Path" + ctx.getContextPath());
    System.out.println("Getting the port is a bit trickier");
    System.out.println("One valid Port = " + ctx.getServer().getConnectors()[0].getPort());
}