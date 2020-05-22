BitSet bitSet = new BitSet(encoded.length());
int bitcounter = 0;
for(Character c : encoded.toCharArray()) {
    if(c.equals('1')) {
        bitSet.set(bitcounter);
    }
    bitcounter++;
}