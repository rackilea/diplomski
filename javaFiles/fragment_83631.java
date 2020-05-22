private rotateLeftChild(Node q) {
    Node p = q.Left;

    Swap(q.Value, p.Value); 

    A = p.Left;
    B = p.Right;
    C = q.Right;

    q.Left  = A;
    q.Right = p;

    p.Left  = B;
    p.Right = C;
}