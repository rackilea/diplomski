List<List<Integer>> result = Arrays.asList(
      Arrays.asList(-1, 0, 1),
      Arrays.asList(-1, 2, -1),
      Arrays.asList(0, 1, -1)
);
HashMap<Set<Integer>, List<Integer>> final_sol = new HashMap<>();

for (List<Integer> list : result) {
  final_sol.put(new HashSet<>(list), list);
}

System.out.println(final_sol.values());