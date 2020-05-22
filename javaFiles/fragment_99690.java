class State {
    final int field1;
    final String field2;
    State(int f1, String f2) {
        this.field1 = f1;
        this.field2 = f2;
    }
    State derive(int arg1) {
        ...
    }
}

private final AtomicReference<State> state = new AtomicReference<>(new State(0, ""));

public void changeState(int whatever) {

    for (;;) {
        final State s = state.get();
        final State t = s.derive(whatever);
        if (state.compareAndSet(s, t)) return;
    }
}