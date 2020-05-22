double a = 2.0;
    Double b = 2.0;
    // assertEquals(a,b); // fails to compile
    // the compiler is confused whether to use
    assertEquals((Object) a,(Object) b); // OK
    // or
    assertEquals(a,(double) b); // OK