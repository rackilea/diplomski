public static class AClassInitializer {
    private final AClass pattern;
    private String value1;
    private String value2;

    private AClassInitializer(AClass pattern) {
        this.pattern = pattern;
    }

    public AClassInitializer field1(String value1) {
        this.value1 = value1;
        return this;
    }

    public AClassInitializer field2(String value2) {
        this.value2 = value2;
        return this;
    }

    public AClass init() {
        pattern.setField1(value1);
        pattern.setField2(value2);
        return pattern;
    }
}

public AClass method1(AClass instance) {
    return new AClassInitializer(instance).field1(value1).field2(value2).init();
}