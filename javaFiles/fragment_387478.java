public class ActionMenuBuilderListener implements ServletContextListener,DispatcherListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Dispatcher.addDispatcherListener(this);
    }

    @Override
    public void dispatcherInitialized(Dispatcher du) {
        Map<String, Map<String, ActionConfig>> runtimeActionConfigs = du
            .getConfigurationManager().getConfiguration().getRuntimeConfiguration()
            .getActionConfigs();
    }
    // other methods
}