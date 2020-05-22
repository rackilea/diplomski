// following method is invoked one time, when you web application starts (is deployed)
@Override
public void contextInitialized(ServletContextEvent servletContextEvent) {
    // ...
    final int numberOfThreads = ...;
    final ExecutorService threadPool = Executors.newFixedThreadPool(numberOfThreads); // starts thread pool
    final ServletContext servletContext = servletContextEvent.getServletContext();
    servletContext.setAttribute("threadPoolAlias", threadPool);
    // ...
}

// following method is invoked one time when your web application stops (is undeployed)
public void contextDestroyed(ServletContextEvent servletContextEvent) {
    // following code is just to free resources occupied by thread pool when web application is undeployed
    final ExecutorService threadPool = (ExecutorService) servletContextEvent.getServletContext().getAttribute("threadPoolAlias");
    threadPool.shutdown();
}