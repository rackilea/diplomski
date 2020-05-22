ThreadLocal<PersistenceManager> pm = new  ThreadLocal<PersistenceManager>(){
    @Override
    protected PersistenceManager initialValue() {
        return JDOHelper.getPersistenceManagerFactory().getPersistenceManager();
    }
};