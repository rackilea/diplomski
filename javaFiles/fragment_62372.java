class Pair {
    int a;
    int b;

    Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean equals(other: Object) {
        if (other == null) { return false; }
        if (other instanceof Pair) {
            Pair otherPair = (Pair)other;
            return a == otherPair.a && b == otherPair.b;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return a * 31 + b;
    }
}