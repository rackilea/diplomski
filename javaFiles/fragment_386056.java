public TestClass() {
        checkCall = (newParam) -> newParam.equals(someDoubleMethod());
        checkCall = (newParam) -> newParam.equals(someLongMethod());
    }

    public double someDoubleMethod() {
        return 0;
    }

    public long someLongMethod() {
        return 0L;
    }