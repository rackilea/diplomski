@Component
 public class Initiator {
    @Reference
    BundleActivator ba;

    @Referenc
    MyService myService;

    @Activate void activate(BundleContext context) throws Exception {
      ba.start(context);
    }

    @Deactivate void deactivate(BundleContext context) throws Exception {
      ba.stop(context);
    }
 }