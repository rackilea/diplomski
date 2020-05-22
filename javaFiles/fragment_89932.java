public interface PrimaryKey<TKey extends Comparable<TKey>> {
    TKey getId();
}

public class PrimaryKeyComparator<TKey extends Comparable<TKey>> 
                                 implements Comparator<PrimaryKey<TKey>> {
    public int compare(PrimaryKey<TKey> first, PrimaryKey<TKey> second) {
        return first.getId().compareTo(second.getId());
    }
}