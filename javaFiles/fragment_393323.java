final int x;
try {
    x = blah();
} catch (MyPanicException e) {
    abandonEverythingAndDie();
    throw new AssertionError("impossible to reach this place"); // or return;
}
System.out.println("x is " + x);