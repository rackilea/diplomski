class Edge implements Comparable<Edge> { // Important: must implement Comparable. More on this later
    public Node first; // first connected node
    public Node second; // second connected node
    public int weight; // move edge weight to Edge class

    @Override
    public int compareTo(Edge e) {
        if (weight < e.weight) {
            return -1;
        } else if (weight > e.weight) {
            return 1;
        } else {
            return 0;
        }
    }
}