enum MyEnum {
    X((String x) -> "Hello"), Y((Double d) -> 1);

    Function<?, ?> function;

    MyEnum(Function<?, ?> function) {
        this.function = function;    
    }
}