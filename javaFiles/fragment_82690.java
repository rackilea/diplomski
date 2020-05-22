@WebListener
public class SchedulerListener implements ServletContextListener, PortalLifecycle, MessageListener {

    private SchedulerEventMessageListenerWrapper listenerWrapper;

    public void contextInitialized(final ServletContextEvent sce) {
        // Wait until the portal is ready
        PortalLifecycleUtil.register(this, PortalLifecycle.METHOD_INIT);
    }

    public void portalInit() {
        // Register our listener
        listenerWrapper = new SchedulerEventMessageListenerWrapper();

        listenerWrapper.setGroupName(getClass().getName());
        listenerWrapper.setJobName(getClass().getName());
        listenerWrapper.setMessageListener(this);

        listenerWrapper.afterPropertiesSet();

        MessageBusUtil.registerMessageListener(DestinationNames.SCHEDULER_DISPATCH, listenerWrapper);
    }

    public void contextDestroyed(final ServletContextEvent event) {
        // Unregister
        if (listenerWrapper != null) {
            MessageBusUtil.unregisterMessageListener(DestinationNames.SCHEDULER_DISPATCH, listenerWrapper);
        }
    }

    public void portalDestroy() {
        // Ignore
    }

    public void receive(final Message message) {
        // ... your job code here ...
    }

}