public class MainUI extends UI implements ErrorHandler {
    private static final long serialVersionUID = 1L;

    @Override
    protected void init(VaadinRequest request) {
        VaadinSession.getCurrent().setErrorHandler(this);
        @SuppressWarnings("unused")
        DiscoveryNavigator navigator = new DiscoveryNavigator(this, this);
    }

    @Override
    public void error(com.vaadin.server.ErrorEvent event) {

        if (event.getThrowable() instanceof AccessDeniedException) {
            AccessDeniedException accessDeniedException = (AccessDeniedException) event.getThrowable();
            Notification.show(accessDeniedException.getMessage(), Notification.Type.ERROR_MESSAGE);
            getUI().getNavigator().navigateTo(FirstView.NAME);
            return;
        }
        // connector event
        if (event.getThrowable().getCause().getCause().getCause() instanceof AccessDeniedException) {
            AccessDeniedException accessDeniedException = (AccessDeniedException) event.getThrowable().getCause().getCause().getCause();
            Notification.show(accessDeniedException.getMessage(), Notification.Type.ERROR_MESSAGE);
            getUI().getNavigator().navigateTo(FirstView.NAME);
            return;
        }
    }
}