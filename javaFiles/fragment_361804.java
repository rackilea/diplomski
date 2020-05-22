HashMap<Key, Integer> adjacencyMatrix = new HashMap<>();
adjacencyMatrix.put(new Key("Berlin", "London"), 933);

Integer distance = adjacencyMatrix.get(new Key("Berlin", "Paris"));
if (distance == null){
    //no entry
}