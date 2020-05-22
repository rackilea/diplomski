private static interface A {
    void apply(String name, int i, int j);
}
private final A method_A = this::methodOne;
private final A method_B = this::methodTwo;
public void methodOne(String name, int i, int j){
    // do something
}
public void methodTwo(String name, int i, int j){
    // do some other thing
}