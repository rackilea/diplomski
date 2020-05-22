@Component(immedate=true, provide={}, serviceFactory=true, configurationPolicy=require)
public class Mine {
    BundleContext context;
    volatile ServiceRegistration r;

    @Activate
    void activate(BundleContext context, Map<String,Object> map) {
         this.context = context;
         track(map);
    }

    @Deactivate
    void deactivate() {
        if ( r != null)
              r.unregisterService();
    }

    void track(Map<String,Object> map) {
       ... // do your remote stuff
       r = context.registerService(...);
       ...
    }
}