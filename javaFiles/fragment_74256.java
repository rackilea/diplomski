public int maxSum() {
    /* case 1 */
    if(left == null && right == null)
        return data;

    /* case 2 */
    if(right == null)
        return data + left.maxSum();
    else if(left == null)
        return data + right.maxSum();

    /* case 3 */
    return Math.max(data + left.maxSum(), data + right.maxSum());
}