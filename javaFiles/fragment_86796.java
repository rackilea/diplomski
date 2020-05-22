public EdgeBetweennessClusterer(int numEdgesToRemove) {
    mNumEdgesToRemove = numEdgesToRemove;
    edges_removed = new LinkedHashMap<E, Pair<V>>();
}

public static void main(String args[]) {
    new EdgeBetweennessClusterer(10);
}