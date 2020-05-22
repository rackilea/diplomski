public default boolean checkFalse(Object f) {
    if(f instanceof testest) {
        ((testest)f).someMethod();
    } else
        throw new RuntimeException();
}