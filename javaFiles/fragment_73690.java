interface Demo {
    public <S, T> void show();
}

class DemoImpl implements Demo {
    @Override
    public <T> void show() { }  // Compiler error
}