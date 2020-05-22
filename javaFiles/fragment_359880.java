int l = getLevel(node.left);
// l == -2147483648 == Integer.MIN_VALUE assuming your base case is hit
int r = getLevel(node.right);
// assuming positive r, then Math.abs() will return a massively positive number
if (Math.abs(l - r) > 1)
        return -99;