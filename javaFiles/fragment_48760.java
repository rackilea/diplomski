interface FooBuilder<T, B extends FooBuilder<T, B>> { 
    B a(String s);
    B b(String s);
    T build();
}

interface BarBuilder<T, B extends BarBuilder<T, B>> 
        extends FooBuilder<Bar, BarBuilder> {
    B c(String s);
    T build();
}