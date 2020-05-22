...
int[] lastNode = new int[nnodes];
lastNode[source] = source;
for (int i = 0; i < nnodes; ++i)
    for (int j = 0; j < edges.size(); ++j) {
        if (distance[edges.get(j).source] == INF) continue;
        int newDistance = distance[edges.get(j).source] + edges.get(j).weight;
        if (newDistance < distance[edges.get(j).destination])
        {
            distance[edges.get(j).destination] = newDistance;
            lastNode[edges.get(j).destination] = edges.get(j).source;
        }
    }