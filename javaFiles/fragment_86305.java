public abstract class OurCallable<TYPE> implements Callable<TYPE> {
    private final String tenantId;

    @Autowired
    private SessionFactory sessionFactory;

    // More fields here

    public OurCallable(String tenantId) {
        this.tenantId = tenantId;
    }

    @Override
    public final TYPE call() throws Exception {
        TenantProvider.setTenant(tenantId);
        startSession();

        try {
            return callInternal();
        } finally {
            stopSession();
        }
    }

    protected abstract TYPE callInternal();

    private void startSession(){
        // Implementation skipped for clarity
    }

    private void stopSession(){
        // Implementation skipped for clarity
    }
}