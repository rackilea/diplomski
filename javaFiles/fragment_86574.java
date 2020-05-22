public <T extends ICar> T myMethod(Class<T> type) {
    try {
        T myCar = type.newInstance(); // T needs a visible no-args constructor
        myCar.SetMake("Ferrari");
        return myCar;
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}