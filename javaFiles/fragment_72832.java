private static class FixedSizeBitSet extends BitSet {
    private final int nbits;

    public FixedSizeBitSet(final int nbits) {
        super(nbits);
        this.nbits = nbits;
    }

    @Override
    public String toString() {
        final StringBuilder buffer = new StringBuilder(nbits);
        IntStream.range(0, nbits).mapToObj(i -> get(i) ? '1' : '0').forEach(buffer::append);
        return buffer.toString();
    }
}