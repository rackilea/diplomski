import java.util.BitSet;

public static BitSet composite(int max) {
    BitSet composite = new BitSet(max);
    max = composite.size();
    for (int i = 4; i < max; i += 2) composite.set(i, true);
    for (int i = 9; i < max; i += 6) composite.set(i, true);
    int p = 5;
    while (p*p < max) {
        if (!composite.get(p)) {
            for (int i = p*p; i < max; i += p*2) composite.set(i, true);
        }
        p += 2;
        if (p*p >= max) break;
        if (!composite.get(p)) {
            for (int i = p*p; i < max; i += p*2) composite.set(i, true);
        }
        p += 4;
    }
    return composite;
}