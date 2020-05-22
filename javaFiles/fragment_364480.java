static interface ParameterType<T> {}

static enum ParameterTypeEnum implements ParameterType<String> { EMAIL; }

public static void main(String[] args) {
    ParameterBuilder
           .start(ParameterTypeEnum.EMAIL)
           .setName("email")
           .setDefaultValue("foo@bar.com")
           .build();
}

public static class ParameterBuilder<T> {

    private String name;
    private T defaultValue;

    public static <T2> ParameterBuilder<T2> start(ParameterType<T2> paramType) {
        return new ParameterBuilder<T2>();
    }

    ParameterBuilder<T> setName(String name) {
        this.name = name;
        return this;
    }

    ParameterBuilder<T> setDefaultValue(T defaultValue) {
        this.defaultValue = defaultValue;
        return this;
    }

    void build() {}
}