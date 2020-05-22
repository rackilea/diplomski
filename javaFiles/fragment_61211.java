public Node gen(int depth){ 
    Node n = new Node();
    if (depth == 6){
        n.depth = height;
    } else {
        n.depth = depth;            
        n.e1 = gen(depth+1);
        n.e2 = gen(depth+1);
        n.e3 = gen(depth+1);
        n.p1 = gen(depth+1);
        n.p2 = gen(depth+1);
        n.p3 = gen(depth+1);
    }
    return n;
}