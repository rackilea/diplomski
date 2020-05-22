public SomeObject getSomeObject() {
    if (someObject == null) {
        someObject = loadSomeObject(); // A private method.
    }

    return someObject;
}