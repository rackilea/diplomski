class testClass<T> {
    Class<T> myClass;

    testClass(Class<T> inputClass) {
        this.myClass = inputClass;
    }

    void createInstance() throws NoSuchMethodException, InstantiationException, 
                IllegalAccessException, InvocationTargetException {
        T anInstance = myClass.getDeclaredConstructor().newInstance();
    }
}