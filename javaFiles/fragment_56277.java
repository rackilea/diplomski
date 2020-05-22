public boolean contains(E item) {
    int comp = item.compareTo(value);
    if(comp  == 0) return true;
    if(comp < 0 && left != null && left.contains(item)) return true;
    if(comp > 0 && right != null && right.contains(item)) return true;
    // no matching node was found
    return false;
}