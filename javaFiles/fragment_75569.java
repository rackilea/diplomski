public Map<String, Integer> computeAllDistances(String source, Map<String, Territory> territoriesMap) {
    Queue<String> q = new ArrayDeque<>();
    Map<String, Integer> dist = new HashMap<>();
    q.add(source);
    dist.put(source, 0);
    while (!q.isEmpty()) {
        Territory cur = territoriesMap.get(q.poll());
        int curDist = dist.get(cur.getName());
        for (String neighbor : cur.getAdjacentTerritories()) {
            if (!dist.containsKey(neighbor)) {
                dist.put(neighbor, curDist + 1);
                q.add(neighbor);
            }
        }
    }
    return dist;
}