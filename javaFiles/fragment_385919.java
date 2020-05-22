class Female implements Comparable<Female> {
    // ...
    public int compareTo(Female that) {
        if (this.age < that.age) {
            return -1;
        } else if (this.age > that.age) {
            return 1;
        }
        return 0;
    }
}