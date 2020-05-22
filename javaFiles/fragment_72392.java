static BitSet toBitSet(int i) {
    BitSet bs = new BitSet(Integer.SIZE);
    for (int k = 0; k < Integer.SIZE; k++) {
        if ((i & (1 << k)) != 0) {
            bs.set(k);
        }
    }
    return bs;
}
static int toInt(BitSet bs) {
    int i = 0;
    for (int pos = -1; (pos = bs.nextSetBit(pos+1)) != -1; ) {
        i |= (1 << pos);
    }
    return i;
}