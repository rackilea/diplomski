List<List<Integer>> tree = new ArrayList<>();

int longestPath(int[] T) {
  int n = T.length;
  for (int i = 0; i < n; i++) {
    tree.add(new ArrayList<>());
  }
  //we do this to denote that there is an edge between u and T[u] and vice-versa
  for (int u = 0; u < n; u++) {
    if (u != T[u]) {
      tree.get(u).add(T[u]);
      tree.get(T[u]).add(u);
    }
  }

  return recurse(0, -1, false);
}