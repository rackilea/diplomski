int currentPathLen = Integer.MAX_VALUE, current = -1;
for (int v: vertices) {
    if (dist[v] < currentPathLen) {
        current = v;
        currentPathLen = dist[current];
    }
}