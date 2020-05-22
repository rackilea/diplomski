Results calculate(Tree node) {
    if (node == null) return new Results(0,0,0);
    else {
        Results leftResults = calculate(node.left);
        Results rightResults = calculate(node.right);
        int leftLength = 1 + leftResults.leftLength;
        int rightLength = 1 + rightResults.rightLength;
        int maxLength = Math.max(Math.max(leftLength, rightLength), 
                                 Math.max(leftResults.maxLength, rightResults.maxLength));
        return new Results(leftLength, rightLength, maxLength);
    }
}