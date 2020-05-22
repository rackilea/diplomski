public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (!(obj instanceof ItemPair))
        return false;
    IterPair other = (IterPair) obj;
    return this.item1.equals(other.item1) && this.item2.equals(other.item2);
}