/**
 * Create a new DayLog object with the current set of states. 
 * This constructor will make a deep copy of the states so they cannot be
 * changed later outside of this log.
 * @param currentStates the states as they exist right now
 */
public DayLog(Map<Integer, State> currentStates) {
    this.states = new HashMap<>();
    for(Integer key : currentStates.keySet()) {
        State state = currentStates.get(key);
        State newState = new State(state); // assuming copy constructor
        this.states.put(key, newState);
    }
}