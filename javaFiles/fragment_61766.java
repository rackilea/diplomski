Var<Integer> a = Var.newSimpleVar(2);
    Var<Integer> b = Var.newSimpleVar(3);
    Var<Integer> c = Var.newSimpleVar(4);
    ...

    EventStream<Integer> m = EventStreams.merge(a.values(), b.values(), c.values(), ...);
    m = m.accumulate((i1, i2) -> i2 < 1 ? Integer.MAX_VALUE : Math.min(i1, i2)).filter(integer -> integer != Integer.MAX_VALUE);
    m.subscribe(integer -> System.out.println(integer));

    a.setValue(0);
    b.setValue(5);
    c.setValue(3);
    a.setValue(4);