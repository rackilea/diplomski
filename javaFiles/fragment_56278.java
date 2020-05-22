public boolean add(E item) {
    if(item.compareTo(value) < 0) {
        if (left == null) left = new BSTNode(item); return true;
        else return left.add(item);
    }
    if(item.compareTo(value) > 0) {
        if (right == null) right = new BSTNode(item); return true;
        else return right.add(item);
    }
    return false;
}