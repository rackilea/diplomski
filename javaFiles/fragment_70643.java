public int sum(Node root) {
    if (root == null) {
        return 0;
    } else if ( root.childNodes == null) {
        return root.value;
    }

    int sum = root.value;
    for ( Node child : root.childNodes ) {
        sum += sum(child);
    } 
    return sum;
}