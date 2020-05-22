// I assume start <= end has already been checked
private int matchQuery(BST bst, String start, String end) {
    if (bst == null) return 0;
    if (bst.key == null) return matchQuery(bst.left, start, end) + matchQuery(bst.right, start, end);

    int count = 0;

    int compareToStart = bst.key.compareTo(start);
    int compareToEnd = bst.key.compareTo(end);

    if (compareToStart > 0) count += matchQuery(bst.left, start, end);
    if (compareToEnd < 0) count +=  matchQuery(bst.right, start, end);   
    if (compareToStart >= 0 && compareToEnd <= 0) count++;
    return count;    
}