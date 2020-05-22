@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + p;
    result = prime * result + q;
    return result;
}

@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    Fraction other = (Fraction) obj;
    if (p != other.p)
        return false;
    if (q != other.q)
        return false;
    return true;
}