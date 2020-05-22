class GuiceModule extends AbstractModule {

    @Provides @RequestScoped
    PersistenceManager providePersistenceManager(){
        return JDOHelper.getPersistenceManagerFactory().getPersistenceManager();
    }

    @Override
    protected void configure() {}
}