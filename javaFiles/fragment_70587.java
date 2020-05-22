// input parameter must be of type Integer or any supertype,
// so that we can safely pass in an Integer
String combine(ConstrainedBiFunction<? super Integer, String> function) {
    return function.apply(1, 2);
}

void test() {
    ConstrainedBiFunction<Object, String> concat = buildBiFxnWithSameTypeArgs();
    ConstrainedBiFunction<Integer, String> sum = (a, b) -> String.valueOf(a + b);
    System.out.println(combine(concat)); // "12"
    System.out.println(combine(sum));    // "3"
}