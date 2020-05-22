class GeneKey implements Comparable<GeneKey> {

    String PN;
    int PW;

    // Generator makes unique TreeMap key.
    GeneKey(String a, int b){
        this.PN = a;
        this.PW = b;
    }
    public int compareTo(GenKey other) {
        int res = PN.compareTo(other.PN);
        return (res != 0) ? res : Integer.compare(PW, other.PW);
    }
}