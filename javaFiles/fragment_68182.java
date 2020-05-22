private transient SomeService localServiceRef;
SomeService getSomeService() {
    if (localServiceRef == null) {
        localServiceRef = SomeService.getInstance();
    }
    return localServiceRef;
}