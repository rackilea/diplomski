public Set<String> readFileIntoSet(String fileName) {
  Set<String> result = new HashSet<String>();
  for (Scanner sc = new Scanner(new File(fileName)); sc.hasNext(); ) 
    result.add(sc.nextLine());
  return result;
}