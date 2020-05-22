@Override
public int compareTo(Pair<F, S> that) {
    int cmp = this.first.compareTo(that.first);
    if (cmp == 0)
        cmp = this.second.compareTo(that.second);
    return cmp;
}