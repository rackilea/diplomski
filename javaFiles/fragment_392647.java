private final Holder h1 = new Holder();
private final Holder h2 = h1;

private static class Holder {
    int a;
    int trap;
}

@Actor
public void actor1() {
    h1.a = 1;
}

@Actor
public void actor2(IntResult2 r) {
    Holder h1 = this.h1;
    Holder h2 = this.h2;
    h1.trap = 0;
    h2.trap = 0;
    r.r1 = h1.a;
    r.r2 = h2.a;
}