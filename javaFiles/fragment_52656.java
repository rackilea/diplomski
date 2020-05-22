interface MyFunc3<A,B,C,R> {
    R apply(A a, B b, C c);
    default BiFunction<B,C,R> bind(A a) {
        return (b, c) -> apply(a, b, c);
    }
}
interface MyFunc4<A,B,C,D,R> {
    R apply(A a, B b, C c, D d);
    default MyFunc3<B,C,D,R> bind(A a) {
        return (b, c, d) -> apply(a, b, c, d);
    }
}