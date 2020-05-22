private File baseDirectory;

public Foo() {
    this(new File("."));
}

public Foo(File baseDirectory) {
    this.baseDirectory = baseDirectory;
}

public void doSomething() {
    final File file = new File(baseDirectory, "XXX" + (new Random().next()) + ".txt");
    file.createNewFile();
}