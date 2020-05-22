new MapMaker().weakKeys()
.concurrencyLevel(16)
.expireAfterAccess(5, TimeUnit.MINUTES) 
.maximumSize(1000)
.makeComputingMap(new Function<Class<?>, ServiceClass>() {
    @Override
    public ServiceClass apply(Class<?> myClass) {
        return new ServiceClass(myClass);
    }
});