public int findSum(Node root, int k) {
    int[] count = {0};
    return findSumRec(root, k, count);
}

private int findSumRec(Node root, int k, int[] count) {

    if(root == null)
        return 0;
    if(count[0] > k)
        return 0;

    int sum = findSumRec(root.left, k, count);
    if(count[0] >= k)
        return sum;

    sum += root.val;
    count[0]++;

    if(count[0] >= k)
        return sum;
    return sum + findSumRec(root.right, k, count);
}