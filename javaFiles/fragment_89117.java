public class Activator implements BundleActivator {
    ...
    private static BundleContext context;
    ...

    public static BundleContext getContext() {
        return context;
    }
    ...
    public void start(BundleContext bundleContext) throws Exception {
        ServiceReference<?> logser = bundleContext.getServiceReference(LogService.class);
        LogService ls = (LogService)bundleContext.getService(logser);
        //print an error to test it (note, that info can be below the threshold)
        ls.log(LogService.LOG_ERROR, "The bundle is starting...");
        Activator.context = bundleContext;
    }
    ...
}