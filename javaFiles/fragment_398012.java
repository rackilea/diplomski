enum State {
    G(Collections.emptySet()),
    F(Collections.singleton(G)),
    M(Collections.singleton(F)),
    B(Collections.singleton(M)),
    I(Collections.singleton(B)),
    W(Collections.singleton(M)),
    P(new HashSet<>(Arrays.asList(W, I)));

    private final Set<State> validTransitions;

    State(final Set<State> validTransitions) {
        this.validTransitions = validTransitions;
    }

    public State transitionTo(final State next) {
        if(!validTransitions.contains(next)) {
            throw new IllegalStateException();
        }
        return next;
    }
}