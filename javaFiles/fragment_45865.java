class StateMachine {
    private Map<StateType, State> states = new HashMap<StateType, State>() {{
        put(StateType.WAKE_UP, new WakeUpState()); 
        put(StateType.GET_DRESSED, new GetDressedState()); 
        put(StateType.GET_CAR_KEYS, new GetCarKeysState()); 
        put(StateType.GET_IN_CAR, new GetInCarState()); 
        put(StateType.DRIVE_TO_WORK, new DriveToWorkState()); 
        put(StateType.WORK, new WorkState()); 
    }};

    private StateType currentState = StateType.WAKE_UP;

    private boolean hasCarKeys;

    public boolean hasKeys() {
        return hasCarKeys;
    }

    public void setHasKeys(boolean hasKeys) {
        hasCarKeys = hasKeys;
    }

    public void update() {
        currentState = states.get(currentState).next(this);
    }
}