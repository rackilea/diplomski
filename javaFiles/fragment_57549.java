Long get(int key) {
    int h = hash(key);

    // look in principal location for this key
    if (change[h] && keys[h] == key)
        return values[h];

    // nope, scan table (wrapping around at the end)
    // and stop when we have found the key, scanned
    // the whole table, or met an empty slot
    int h0 = h; // save original position
    while ((h = (h+1) % size) != h0 && change[h])
        if ( keys[h] == key)
            return values[h];

    return null;
}