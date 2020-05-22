private int x;

public TestClass(int x) {
    setX(x);
}

public void setX(int x) {
    // Some random condition depending on other variables.
    if (System.currentTimeMillis() & 1 == 0) {
        this.x = 5;
    } else {
        this.x = x;
    }
}