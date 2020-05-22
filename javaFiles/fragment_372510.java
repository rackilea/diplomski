public boolean equals(Object o) {
    if (o instanceof SetType) {
        SetType other = (SetType) o;
        if (i == other.i) {
            return true;
        }
    }
    return false;
}