public void foo(int a, int b) {
    // do something with a and b
}

public void foo(int a) {
    // supply default value of 0 for b
    foo(a, 0);
}