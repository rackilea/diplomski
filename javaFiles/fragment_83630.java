private Splay(Node parent, Node cur, Node n, bool canMoveUpTwice = false) {
    if (cur.Value > n.Value)
        Splay(cur, cur.Left, n, !canMoveUpTwice);
    else
        Splay(cur, cur.Right, n, !canMoveUpTwice);

    if (canMoveUpTwice)
        MoveUpTwice();
    else
        MoveUpOnce();

    if (parent.Left == cur)
        parent.Left = n;
    else
        parent.Right = n;

    if (Parent == null)
        tree.Root = n;
}