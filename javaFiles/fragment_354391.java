class C<T extends A & B> {
    ArrayList<T> field;

    public <T2 extends A & B> void method() {
        ArrayList<T2> localVar;
    }
}