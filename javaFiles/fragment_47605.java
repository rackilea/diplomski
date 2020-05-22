class X {
    public X ()
    {
        a = new A();
        b = new B();
        c = new C();
        d = new D();
    }

    public void start () throws Exception
    {
        assert(state == 0);
        try {
            a.start();
            state = 1;
            b.start();
            state = 2;
            c.start();
            state = 3;
            d.start();
            state = 4;
        } catch (Exception e) {
            stop();
            throw e;
        }
    }

    public void stop ()
    {
        if (state >= 4) d.stop();
        if (state >= 3) c.stop();
        if (state >= 2) b.stop();
        if (state >= 1) a.stop();
        state = 0;
    }

    private int state;
    private A a;
    private B b;
    private C c;
    private D d;
}