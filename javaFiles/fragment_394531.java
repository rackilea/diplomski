int current = Integer.MAX_VALUE;
for (int v: vertices) {
    if (dist[v] < current) {
        current = v;
    }
}