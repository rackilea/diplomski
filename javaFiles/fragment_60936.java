public class SimpleEntryComparable<K extends Comparable<? super K>, V>
extends SimpleEntry<K, V>
implements Comparable<SimpleEntryComparable<K, V>> {

    @Override
    public int compareTo(final SimpleEntryComparable<K, V> other) {
        return getKey().compareTo(other.getKey());
    }
}