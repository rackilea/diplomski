public void dls(int limit) {
    Set<Integer> visited = new HashSet<>();
    int start = 0;
    stack.push(start);
    display(start);
    int depth = 1;
    while (!stack.isEmpty()) {
        int current = stack.peek();
        visited.add(current);
        int next = -1;
        for (int adj = 0; adj < noOfNodes; adj++) {
            if (neighbourMatrix[current][adj] == 1 && !visited.contains(adj)) {
                next = adj;
            }
        }
        if (depth <= limit) {
            if (next == -1) {
                stack.pop();
                depth--;
            } else {
                stack.push(next);
                display(next);
                depth++;
            }
        } else {
            stack.pop();
            depth--;
        }
    }
}