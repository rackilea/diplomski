private int matchQuery(BST bst, String start, String end) {
    if (bst == null) return 0;

    int count = 0;
    if (bst.key != null && withinRange(bst.key, start, end)) count++; 

    count +=  matchQuery(bst.right, start, end);
    count += matchQuery(bst.left, start, end); 

    return count;    
}