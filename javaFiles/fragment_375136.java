@Override
public int compareTo(RankedObj o) {
    // Handle equality first
    if (this.i == o.i) {
        return 0;
    }
    // Handle the magic value correctly on *both* sides
    if(this.i == 3) {
        return -1;
    }
    if (o.i == 3) {
        return 1;
    }
    // Fall back to normal comparsions
    return Integer.compare(i, o.i);
}