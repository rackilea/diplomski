public static void main(String... args) {
    LockDispenser fooLock = new LockDispenser();
    A fooA = new A(fooLock);
    B fooB = new B(fooLock);


    LockDispenser barLock = new LockDispenser();
    A barA = new A(barLock);
    B barB = new B(barLock);
}