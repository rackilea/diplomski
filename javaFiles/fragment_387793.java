private void loadFactory() {
    ...
    myFactoryRef.set(factory);
}
private AtomicReference<MyFactory> myFactoryRef;
public MyFactory getMyFactory() {
    return myFactoryRef.get();
}