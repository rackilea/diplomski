@Override
public void start(BundleContext context) throws Exception {
    Hashtable<String, String> props = new Hashtable<>();
    props.put("dependencyType", "A");
    srvReg = context.registerService(IMyDependency.class.getName(), myInstance, props);
}