public javaFoo(MyType x) {
    x.setFrobber(true);
}

public javaBar() {
    MyType mt = new MyType();
    foo(mt);
    System.out.println(mt.toString());
}