interface Function {
    void apply();
}

void takesAFunction(Function function) {
    function.apply();
}