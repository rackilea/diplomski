interface MyOperator extends UnaryOperator<String> { }

public static void main(String[] args) {
    List<MyOperator> list =
        Arrays.asList(s -> s + "bar",
                      s -> "[" + s + "]",
                      s -> s + s);

    MyOperator composite =
        list.stream()
            .reduce(s -> s, (a, b) -> s -> b.apply(a.apply(s)));

    System.out.println(composite.apply("foo"));
}