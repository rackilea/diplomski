stack = new Stack<>();
this.visited = new HashSet<>();
this.parentMap = new HashMap<>();

stack.push(source);
visited.add(source);

while (!stack.isEmpty()) {
    int curr = stack.pop();

    if (curr == goal)
        return parentMap;

    for (int n : adjMatrix.getNeighbors(curr)) {
       if (! visited.contains(n)) {
         visited.add(n);
         parentMap.put(n, curr);
         stack.push(n);
       }
    }
}
return parentMap;