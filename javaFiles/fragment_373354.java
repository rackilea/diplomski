public SomeClass (int a, int b) { 
    if (a < 0 || a > 10) {
        throw new AssertionError("the first param is out of valid range: " + a);
    }
    if (b < 0 || b > 10) {
        throw new AssertionError("the second param is out of valid range: " + b);
    }

    // at this point the pre-conditions have been validated
    this.a = a;
    this.b = b;
}