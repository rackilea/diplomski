Stack<Integer> stack = new Stack<Integer>();
stack.push(start);
while (!stack.empty()) {
    int v = stack.pop();
    dfsMarked[v] = true;
    for (Edge e : G.adj(v)) {
        int w = e.other(v);  
        if (!dfsMarked[w]) {
            dfsEdgeTo[w] = v;
            stack.push(w);
        }
    }
}