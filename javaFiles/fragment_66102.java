public class ImmutableIntArrayIterator implements Iterator<Integer>
{
    private final int[] ba;
    private int currentIndex;

    public ImmutableIntArrayIterator(@Nonnull final int[] ba)
    {
        this.ba = ba;
        if (this.ba.length > 0) { this.currentIndex = 0; }
        else { currentIndex = -1; }
    }

    @Override
    public boolean hasNext() { return this.currentIndex >= 0 && this.currentIndex + 1 < this.ba.length; }

    @Override
    public Integer next()
    {
        this.currentIndex++;
        return this.ba[this.currentIndex];
    }

    @Override
    public void remove() { throw new UnsupportedOperationException(); }
}