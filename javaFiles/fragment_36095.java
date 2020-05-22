public void foo(long x) {}
public void foo(float x) {}
public void foo(Double x) {}
public void foo(Object x) {}
public int foo(double x) {
    return 0;
}

// This will only compile if f is declared to return double
int check = foo(f("cat"));