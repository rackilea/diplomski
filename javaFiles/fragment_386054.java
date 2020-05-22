public static class AClassInitializer {
    private final String value1;
    private final String value2;

    public AClassInitializer(String value1, String value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public AClass init(AClass pattern) {
        pattern.setField1(value1);
        pattern.setField2(value2);
        return pattern;
    }
}

AClassInitializer aClassInitializer = new AClassInitializer(value1, value2);

public AClass method1(AClass instance) {
    return aClassInitializer.init(instance);
}