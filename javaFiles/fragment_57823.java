if (x.isY()) {
        x.asY().someYMethod();
    }

    boolean isY(X x) { return x instanceof Y; }
    Y asY(X x) { return (Y) x; }