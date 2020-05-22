public class KlusterComparator implements RawComparator<Kluster> {

private final Kluster key1;
private final Kluster key2;
private final DataInputBuffer buffer;

public KlusterComparator() {
    key1 = new Kluster();
    key2 = new Kluster();
    buffer = new DataInputBuffer();
}

@Override
public int compare(byte[] b1, int s1, int l1, byte[] b2, int s2, int l2) {
    try {
        buffer.reset(b1, s1, l1); // parse key1
        key1.readFields(buffer);

        buffer.reset(b2, s2, l2); // parse key2
        key2.readFields(buffer);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }

    return compare(key1, key2); // compare them
}

@Override
public int compare(Kluster o1, Kluster o2) {
    // compare o1 and o2
    return 0;
}

}