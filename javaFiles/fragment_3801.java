class Super {
    void f2(String s)       {}
    void f3(String s)       {}
    void f3(int i1, int i2) {}
}

class Test {
    void f1(int i) {}
    void f2(int i) {}
    void f3(int i) {}

    void m() {
        new Super() {
            {
                f1(0);  // OK, resolves to Test.f1(int)
                f2(0);  // compile-time error
                f3(0);  // compile-time error
            }
        };
    }
}