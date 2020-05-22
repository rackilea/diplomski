public boolean inBetween(long n) {
    boolean less = false, more = false;
    for (Link current = first; current != null; current = current.next)
        if ((less |= n < current.dData) & (more |= n > current.dData))
            return true;
    return false;
}