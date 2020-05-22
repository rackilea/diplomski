public class TreeTest {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(final int data, final Node left, final Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(final String[] args) {
        final Node three = new Node(3, null, null);

        final Node two = new Node(2, three, null);
        final Node one = new Node(1, null, null);

        final Node five = new Node(5, two, one);
        final Node tree = five;

        for (int i = 0; i <= 10; i++) {
            System.out.println(i + "");
            System.out.println("original = " + hasPathSum(tree, i));
            System.out.println("bert     = " + hasPathSumBert(tree, i));
            System.out.println("mark     = " + hasPathSumMark(tree, i));
            System.out.println();
        }

        System.out.println("hasPathSumBert(null, 0): "+ hasPathSumBert(null, 0));
        System.out.println("hasPathSumBert(null, 1): "+ hasPathSumBert(null, 1));
    }

    static boolean hasPathSum(final Node node, final int sum) {
        // return true if we run out of tree and sum==0
        if (node == null) {
            return (sum == 0);
        } else {
            // otherwise check both subtrees
            final int subSum = sum - node.data;
            return (hasPathSum(node.left, subSum) || hasPathSum(node.right, subSum));
        }
    }

    static boolean hasPathSumBert(final Node node, final int sum) {
        // return true if we run out of tree and sum==0
        if (node == null) {                                   // empty tree
            // choose one:
            return (sum == 0);
            //return false;
        } else if (node.left == null && node.right == null) { // leaf
            return (sum == node.data);
        } else if (sum <= node.data) {                        // sum used up
            return false;
        } else {                                              // try children
            return (node.left != null  && hasPathSumBert(node.left, sum - node.data)) ||
                   (node.right != null && hasPathSumBert(node.right, sum - node.data));
        }
    }

    static boolean hasPathSumMark(final Node node, final int sum) {
        final int subSum = sum - node.data;
        if (node.left == null && node.right == null) {
            return (subSum == 0);
        } else {
            // otherwise check both subtrees
            if (node.left != null  && hasPathSumMark(node.left, subSum))
                return true;
            if (node.right != null && hasPathSumMark(node.right, subSum))
                return true;
            return false;
        }
    }
}