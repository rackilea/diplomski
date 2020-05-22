enum State {
    G(Collections.emptySet()),
    F(Set.of(G)),
    M(Set.of(F)),
    B(Set.of(M)),
    I(Set.of(B)),
    W(Set.of(M)),
    P(Set.of(W, I));

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