public void insert(int val) {
    if(val < key)
        left = handleNode(left, val);
    else
        right = handleNode(right, val);
}