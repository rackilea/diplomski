@Override
public boolean equals(Object obj) {
    if (!(obj instanceof TwoIntClass)) {
        return false;
    }
    TwoIntClass other = (TwoIntClass) obj;

    return (other.i1 == this.i1) && (other.i2 == this.i2); 
}

@Override
public int hashCode() {
    //return TwoIntClass.class.hashCode() | i1 | (i2 << 16);

    // better implementation based on the String class
    int hash = TwoIntClass.class.hashCode();

    hash = (hash * 31) + i1;
    hash = (hash * 31) + i2;

    return hash;
}