private <T extends Foo> void helper(Class<T> p_class) {
    // code
}

public void loadData(Class<? extends Foo> p_class) {
    helper(p_class);
}