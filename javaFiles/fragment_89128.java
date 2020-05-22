public enum State {
    A, B, C, D, E
}

public enum Country {
    USA(State.A, State.B),
    UK(State.C, State.D);

    private final List<State> states;

    Country(State... states) {
        this.states = Arrays.asList(states);
    }

    public List<State> getStates() {
        return states;
    }
}