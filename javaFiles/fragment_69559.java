public class MyListener extends HttpSessionEventPublisher {
    @Override
    public void sessionDestroyed(final HttpSessionEvent event) {
        final ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(event.getSession().getServletContext());
        final MyServiceInterface service = ctx.getBean(MyServiceInterface.class);
        // use service
        super.sessionDestroyed(event);
    }
}