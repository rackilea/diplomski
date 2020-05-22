public void stack() {
    List<String> aList = Arrays.asList("foo2", "baz4");

    B b1 = new B("foo1", "foo2", "foo3", "foo4");
    B b2 = new B("bar1", "bar2", "bar3", "bar4");
    B b3 = new B("baz1", "baz2", "baz3", "baz4");

    List<B> bList = Stream.of(b1, b2, b3).peek(b -> {
        if (aList.contains(b.getExample1())) {
            b.setExample1(null);
        }
        if (aList.contains(b.getExample2())) {
            b.setExample2(null);
        }
        if (aList.contains(b.getExample3())) {
            b.setExample3(null);
        }
        if (aList.contains(b.getExample4())) {
            b.setExample4(null);
        }
    }).collect(Collectors.toList());

    System.out.println(bList);
}