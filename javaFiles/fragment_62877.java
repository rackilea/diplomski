public class MyApplication extends WebApplication {

    public ApplicationContext getAppCtx() {
        return WebApplicationContextUtils.getWebApplicationContext(servletContext);
    }

}