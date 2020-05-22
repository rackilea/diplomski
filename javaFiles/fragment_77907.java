public void enumerate() {
    System.out.println("enumerate: \"" + regex + "\"");
    int level = 0;
    String accumulated = "";
    enumerate(level, accumulated, automaton.getInitialState());
}

private void enumerate(int level, String accumulated, State state) {
    List<Transition> transitions = state.getSortedTransitions(true);
    if (state.isAccept()) {
        System.out.println(accumulated);
        return;
    }
    if (transitions.size() == 0) {
        assert state.isAccept();
        return;
    }
    int nroptions = state.isAccept() ? transitions.size() : transitions.size() - 1;
    for (int option = 0; option <= nroptions; option++) {
        // Moving on to next transition
        Transition transition = transitions.get(option - (state.isAccept() ? 1 : 0));
        for (char choice = transition.getMin(); choice <= transition.getMax(); choice++) {
            enumerate(level + 1, accumulated + choice, transition.getDest());
        }
    }
}