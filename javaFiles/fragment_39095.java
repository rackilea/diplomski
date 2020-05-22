for (Map.Entry<String, Set<Integer>> entry : map.entrySet()) {
  printWriter.print(entry.getKey()+ " ");
  for( Integer setElement : entry.getValue()) {
     printWriter.print(setElement + " ");
  }
  printWriter.println();
}