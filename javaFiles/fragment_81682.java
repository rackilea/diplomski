public static class CustomContextResolver 
        implements InjectionResolver<CustomContext> {

    @Inject
    private ServiceLocator locator;

    @Inject
    private IDaoProviders daoClasses;

    @Inject
    private CloseableService closeableService;

    @Override
    public Object resolve(Injectee injectee, ServiceHandle<?> root) {
        Type requiredType = injectee.getRequiredType();
        for (Class type: daoClasses.getDaoClasses()) {
            if (requiredType == type) {
                IDao dao = locator.getService(IDao.class, type.getCanonicalName());
                addToCloseableService(dao);
                return type.cast(dao);
            }
        }
        return null;
    }
    ...
}