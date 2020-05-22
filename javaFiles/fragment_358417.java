while (!q.isEmpty()) {
    int u = q.peek().v;
    q.remove();
    for (int l = 0; l < n; l++) {
        if (g[u][l] > 1) {
            int alt = distance[u] + g[u][l];
            if (alt < distance[l]) {
                distance[l] = alt;
                q.add(new Vertex(u, distance[l]));
            }
        }
    }
}