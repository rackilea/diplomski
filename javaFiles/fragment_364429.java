class MyClass implements Alpha, Beta {
    public void reset() {
        Alpha.super.reset();
        Beta.super.reset();
    }
}