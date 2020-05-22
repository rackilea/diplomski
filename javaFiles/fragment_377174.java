@Override public int hashCode() {
    int hash = 23;
    hash = hash * 31 + r;
    hash = hash * 31 + c;
    return hash;
}