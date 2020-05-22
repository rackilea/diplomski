public int hashCode() {
   return node *31;
}

public boolean equals(Object o) {
    if (o == this) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Vertex r = (Vertex)o;
    return node == r.node;
}