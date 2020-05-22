private Node ida(Node root, final String h) {
    PriorityQueue<DNode> frontier = new PriorityQueue<DNode>(10, new Comparator<DNode>(){
        @Override
        public int compare(DNode n1, DNode n2) {
            if(h == "h1") {
                if(n1.depth + h1(n1.node) > n2.depth + h1(n2.node)) return 1;
                if(n1.depth + h1(n1.node) < n2.depth + h1(n2.node)) return -1;
                return 0;
            }
            if(h == "h2") {
                if(n1.depth + h2(n1.node) > n2.depth + h2(n2.node)) return 1;
                if(n1.depth + h2(n1.node) < n2.depth + h2(n2.node)) return -1;
                return 0;
            }
            return 0;
        }});
    ArrayList<Node> explored = new ArrayList<Node>();
    Node soln = null;
    DNode start = new DNode(root, 1);
    frontier.add(start);
    int d = 0;
    int flimit = (h == "h1" ? h1(start.node) : h2(start.node));
    int min = flimit;
    while(true) {
        DNode dn = frontier.poll();
        if(dn == null) {
            explored.clear();
            frontier.add(start);
            d = 0;
            flimit = min;
            continue;
        }
        d = dn.depth;
        Node n = dn.node;
        //n.print();
        if(goalCheck(n)){
            return n;
        }
        min = Integer.MAX_VALUE;
        for(int i = 0;i < ops.length;i++) {
            String op = ops[i];
            if(n.applicable(op)) {
                soln = n.applyOp(op);
                int h_cost;
                if(h == "h1") h_cost = h1(soln);
                else h_cost = h2(soln);
                if(!checkDup(explored,soln))    {
                    if(d + 1 + h_cost <= flimit) {
                        frontier.add(new DNode(soln, d + 1));
                    }
                    else {
                        if(d + 1 + h_cost < min)min = d + 1 + h_cost; 
                    }
                }
            }
        }
        explored.add(n);
        max_list_size = Math.max(max_list_size, frontier.size() + explored.size());
    }
}