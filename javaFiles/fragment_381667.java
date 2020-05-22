public Foo() {
}

public void doSomething() {
    final File file = new File("XXX" + (new Random().next()) + ".txt");
    file.createNewFile();
}