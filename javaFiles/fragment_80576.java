int result = key.compareTo(curNode.key);
if (curNode.L == null && result < 0) {
    curNode.L = new Node(key, value);
    return true;
}
if (curNode.R == null && result > 0) {
    curNode.R = new Node(key, value);
    return true;
}
if (curNode.L != null && result < 0)
    return insert(curNode.L, key, value);
if (curNode.R != null && result > 0)
    return insert(curNode.R, key, value);
return false;