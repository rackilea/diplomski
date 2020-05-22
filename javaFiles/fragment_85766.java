private void findAllPaths(Graph mapa, List<Integer> visited,
        List<ArrayList<Integer>> paths, Integer currentNode) {

    if (currentNode.equals(startNode)) { 
        paths.add(new ArrayList<Integer>(visited));
        return;// <--- WRONG!!!
    } else {
        // The else is never executed!
    }
}