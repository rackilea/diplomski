// somewhere in the class
private static final Map<Integer, String> SOME_NAME = new HashMap<>();
static {
    SOME_NAME.put(1, "Hey");
    SOME_NAME.put(2, "Hi");
}

private String myMethod(int a_var) {
    return SOME_NAME.getOrDefault(a_var, "Hello");
}