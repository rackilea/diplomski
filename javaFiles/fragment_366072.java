private void relax(Vertice u, Vertice v, int weight) {
    if(u.distance != Integer.MAX_VALUE && v.distance > u.distance + weight) {
        v.distance = u.distance + weight;
        v.predecessor = u;
    }
}