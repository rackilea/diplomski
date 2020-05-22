public class MyApplicationContext implements ApplicationContextAware {

    private static ApplicationContext appContext;

    /* (non-Javadoc)
     * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
     */
    @Override
    public void setApplicationContext(ApplicationContext globalAppContext)
        throws BeansException {

        this.appContext = globalAppContext;

    }

    public static ApplicationContext getApplicationContext() {
        return appContext;
    }

}