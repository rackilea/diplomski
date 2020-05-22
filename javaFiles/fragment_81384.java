class Graph {
    //Map of adjacency lists for each node
    Map<Integer, List<Integer>> adj;

    public Graph(int[] nodes) {
        //your node labels are consecutive integers starting with one. 
        //to make the indexing easier we will allocate an array of adjacency one element larger than necessary
        adj = new HashMap<Integer, LinkedList<Integer>>();
        for (int i = 0; i < nodes.length; ++i) {
            adj.put(i, new LinkedList<Integer>());
        }
    }

    public addNeighbor(int v1, int v2) {
        adj.get(v1).add(v2);
    }

    public List<Integer> getNeighbors(int v) {
        return adj.get(v);
    }

}