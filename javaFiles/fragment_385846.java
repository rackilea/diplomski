public class EmptyBlock implements IBlocks {
    @Override
    public IResting getFirst() {
        return new EmptyResting();
    }
}