public final class Seeker<E, K> {

    private final E structure;
    private final SearchStrategy strategy;

    public Seeker(final E aStructure, final SearchStrategy aStrategy) {
        structure = aStructure;
        strategy = aStrategy;
    }

    public boolean search(K aKey) {
        return strategy.search(structure, key); //Pretty generic.
    }

}