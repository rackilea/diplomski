public synchronized long add() {
    return a + b + c;
}

public synchronized void foo() {
    b = 0;
}