interface U0 { }
static class U1 implements U0 {
    public int x = 1;
}
static class U2 extends U1 { }

static abstract class M<C extends List<? extends U0>> {
    C field;
    public abstract boolean check(C c);
}

static class M1 extends M<List<? extends U1>> {

    @Override
    public boolean check(List<? extends U1> c) {
        return !c.isEmpty() && c.get(0).x > 0;
    }

}

static class MyList<U extends U0> extends ArrayList<U> {
    void callCheck(M<? super MyList<U>> m) {
        m.check(this);
    }
}

static class MyList1 extends MyList<U2> {
}

//...
new MyList1().callCheck(new M1());