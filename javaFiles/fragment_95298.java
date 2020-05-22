public static int fullLevel(Node root) {
    ArrayList<Integer> levelCounts = new ArrayList<>();
    levelCount(root, 0, levelCounts);

    for (int i = levelCounts.size() - 1; i >= 0; i--) {
        if ((int)Math.pow(2, i) == levelCounts.get(i)) {
            return i;
        }
    }

    return -1;
}

private static void levelCount(Node root, int height, ArrayList<Integer> levelCounts) {
    if (root != null) {
        if (height >= levelCounts.size()) {
            levelCounts.add(0);
        }

        levelCounts.set(height, levelCounts.get(height) + 1);

        if (root.left != null && root.right != null) {
            levelCount(root.left, height + 1, levelCounts);
            levelCount(root.right, height + 1, levelCounts);
        }
    }
}