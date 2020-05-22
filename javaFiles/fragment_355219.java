class IntegerSet {
    private final BST bst = new BST();
    private int magnitude;

    public IntegerSet(int[] arr) {
        for(int val : arr)
            bst.insert(val);
        magnitude = bst.getSize();
    }   
}