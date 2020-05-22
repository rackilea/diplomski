private void changeIt(AtomicBoolean b) {
    b.set(!b.get());
}

public void test() {
    AtomicBoolean b = new AtomicBoolean(false);
    changeIt(b);
    System.out.println(b);
}