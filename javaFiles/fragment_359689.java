public HashMapOfArrayList(HashMapOfArrayList source) {
    HashMap<Integer, ArrayList<Integer>> graph = source.getGraph(); // get the source graph

    my_graph = new HashMap<Integer, ArrayList<Integer>>(); //define our graph 
    for(Map.Entry<Integer, ArrayList<Integer>> entry : graph.entrySet()) {
        //iterate through the graph
        ArrayList<Integer> sourceList = entry.getValue();
        ArrayList<Integer> clonedList = new ArrayList<Integer>();
        clonedList.addAll(sourceList);
        //put value into new graph
        my_graph.put(entry.getKey(), clonedList);
    }
}