public Collection<Set<V>> getAllMaximalCliques(Collection<V> initials) {
    // TODO: assert that graph is simple

    cliques = new ArrayList<>();
    List<V> potential_clique = new ArrayList<>();
    List<V> candidates = new ArrayList<>();
    List<V> already_found = new ArrayList<>();

    // candidates.addAll(graph.getVertices());

    for (V v : graph.getVertices()) {
        if (initials.contains(v)) {
            // add initial values to potential clique
            potential_clique.add(v);
        } else {
            // only add to candidates if they are a neighbour of all other initials
            boolean isCandidate = true;
            for (V i : initials) {
                if (!graph.isNeighbor(v, i)) {
                    isCandidate = false;
                    break;
                }
            }
            if (isCandidate) {
                candidates.add(v);
            }
        }
    }

    findCliques(potential_clique, candidates, already_found);
    return cliques;
}