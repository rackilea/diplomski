public static <K,V,M extends Multimap<K,V>> M invertFrom(Multimap<? extends V,? extends K> source,
                                         M dest)

Copies each key-value mapping in source into dest, with its key and value reversed.

Parameters:
    source - any multimap
    dest - the multimap to copy into; usually empty
Returns:
    dest