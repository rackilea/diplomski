public class AdditionAccumulator extends StateAccumulator {
    @Override
    protected long accumulate(long oldState, long newState) {
        return oldState + newState;
    }
}