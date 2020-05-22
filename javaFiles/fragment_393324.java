final int x;
try {
    x = blah();
} catch (MyPanicException e) {
    return abandonEverythingAndDie();
}
System.out.println("x is " + x);