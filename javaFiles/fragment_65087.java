public int getNodeValueByDepth(Node n, int level) {
    int sum = 0;

    /** If we have reached our desired level */
    if (level == 0) {
        if (n != null) {
            /** Assuming data is an int and not nullable */
            return n.data;
        } else {
            /** Change this to 0 if you don't want an error condition */
            return -1;
    }

    /** We are not the desired level, so get the sum of .left and .right, knowing either may not exist */
    if (n.left != null) {
        sum += getNodeValueByDepth(n.left, level-1);
    }

    if (n.right != null) {
        sum += getNodeValueByDepth(n.right, level-1);
    }

    /** Now have evaluated every possible child and stored the sum, even if it is 0 */
    return sum;
}