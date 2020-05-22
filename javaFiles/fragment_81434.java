RedBlackBST tree = new RedBlackBST();
tree.root = tree.put(null, 0, 0);

for (int i = 1; i < 10; i++) {
    tree.root = tree.put(tree.root, i, i);
}
int redTotal = tree.countRed(tree.root);