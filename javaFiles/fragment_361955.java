systemBundleContext = ... create framework
 systemBundleContext.registerService( 
    BundleActivator.class, 
    new BundleActivator() {
        public void start(BundleContext c) {
           // start non-OSGi code
        }
        public void stop(BundleContext c) {
           // stop non-OSGi code
        }
     },
     null );