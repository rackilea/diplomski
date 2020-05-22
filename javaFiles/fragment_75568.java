public int computeDistance(String source, String target, Map<String, Territory> territoriesMap) {
    Queue<String> q = new ArrayDeque<>();
    Map<String, Integer> dist = new HashMap<>();
    q.add(source);
    dist.put(source, 0);
    while (!q.isEmpty()) {
        Territory cur = territoriesMap.get(q.poll());
        int curDist = dist.get(cur.getName());
        for (String neighbor : cur.getAdjacentTerritories()) {
            if (neighbor.equals(target))
                return curDist + 1;
            if (!dist.containsKey(neighbor)) {
                dist.put(neighbor, curDist + 1);
                q.add(neighbor);
            }
        }
    }
    return -1; // not connected by a path
}