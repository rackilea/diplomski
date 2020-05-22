public abstract class StateAccumulator {
    protected abstract long accumulate(long oldState, long newState);

    public handleInput(SomeInputObject input) {
        long inputLong = input.getLong();
        state = accumulate(state, inputLong);
    }

    private long state = SOME_INITIAL_STATE;
}