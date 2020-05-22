for (List<int[]> list : map.values()) {
  for (int i = 0; i < list.size(); ++i) {
    for (int j = 1; j < list.size(); ++j) {
      System.out.printf(
          "Matching pair found: %s %s%n",
          Arrays.toString(list.get(i)),
          Arrays.toString(list.get(j)));
    }
  }
}