public static class DaoFeature implements Feature {

    private final Class<? extends IDao>[] daoClasses;

    public DaoFeature(Class<? extends IDao> ... daoClasses) {
        this.daoClasses = daoClasses;
    }

    @Override
    public boolean configure(FeatureContext context) {
        context.register(new Binder());
        return true;
    } 

    private class Binder extends AbstractBinder {
        @Override
        protected void configure() {
            ...
            for (Class<? extends IDao> daoClass: daoClasses) {
                bind(daoClass).to(IDao.class)
                        .named(daoClass.getCanonicalName()).in(RequestScoped.class);
            }
        }    
    }
}