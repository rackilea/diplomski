public void printLevelOrder(int depth) {
    for (int i = 1; i <= depth; i++) {
        System.out.print("Level " + (i-1) + ": ");
        String levelNodes = printLevel(root, i);
        System.out.print(levelNodes + "\n");
    }
}

public String printLevel(BinaryNode<AnyType> t, int level) {
    if (t == null) {
        return "";
    }
    if (level == 1) {
        return t.element + " ";
    } else if (level > 1) {
        String leftStr = printLevel(t.left, level - 1);
        String rightStr = printLevel(t.right, level - 1);
        return leftStr + rightStr;
    }
    else // you need this to get it to compile
      return "";
}