class MyListener extends ContextLoaderListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        System.out.println();
        System.out.println();
        System.out.println(" hello ContextLoaderListener ");
        System.out.println();
        System.out.println();
    }
}