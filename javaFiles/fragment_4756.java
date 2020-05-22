@Override
public int hashCode() {
    int hash = 7;
    hash = 71 * hash + this.x;
    hash = 71 * hash + this.y;
    return hash;
}