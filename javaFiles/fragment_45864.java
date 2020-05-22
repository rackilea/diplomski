class GetInCarState implements State {
    @Override
    public StateType next(StateMachine  sm) {
        if (sm.hasKeys()) {
            return StateType.DRIVE_TO_WORK;
        }
        return StateType.GET_CAR_KEYS;
    }
}