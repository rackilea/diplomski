public State state() {
    execute('t');
    switch (mError) {
    case NO_ERROR:
        return State.UNLOCKED;
    case LOCKED:
        return State.LOCKED;
    case UNINITIALIZED:
        return State.UNINITIALIZED;
    default:
        throw new AssertionError(mError);
    }
}