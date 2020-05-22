@Override
public int hashCode() {
    int hash = 1;
    hash = hash * 17 + width;
    hash = hash * 31 + height;
    hash = hash * 13 + x;
    hash = hash * 13 + y;
    hash = hash * 13 + velocity.hashcode();
    return hash;
}