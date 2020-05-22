class Tuple implements Comparable<Tuple> {
    int value;  // value
    int pos;    // position in array

    public Tuple(int value, int pos) {
        this.value = value;
        this.pos = pos;
    }

    @Override
    public int compareTo(Tuple other) {  // sort based on values
        return Integer.compare(value, other.value);
    }
}