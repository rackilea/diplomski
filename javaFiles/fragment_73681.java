class Foo {
    public void close() {
        System.out.println("close method is invoked");
    }

}
Foo foo = new Foo();

try {
    Method m = Foo.class.getMethod("close");
    m.invoke(foo);
} catch (NoSuchMethodException e) {
    e.printStackTrace();
}