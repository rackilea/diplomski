static int maxDepth (Node r) {
    int depth = 0;
    Stack<Node> wq = new Stack<>();
    Stack<Node> path = new Stack<>();

    wq.push (r);
    while (!wq.empty()) {
        r = wq.peek();
        if (!path.empty() && r == path.peek()) {
            if (path.size() > depth)
                depth = path.size();
            path.pop();
            wq.pop();
        } else {
            path.push(r);
            if (r.right != null)
                wq.push(r.right);
            if (r.left != null)
                wq.push(r.left);
        }
    }

    return depth;
}