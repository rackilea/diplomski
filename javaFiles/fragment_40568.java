public int solution2(int[] A) {
    BitSet bitSet = new BitSet();
    Arrays.stream(A)
            .filter(i -> i > 0)
            .forEach(bitSet::set);
    return bitSet.nextClearBit(1);
}