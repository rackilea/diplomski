@Override
public int compareTo(Fruit o) {
    if (this.weight > o.weight)
        return 1;
    else if (this.weight < o.weight)
        return -1;
    else
        return 0;
}