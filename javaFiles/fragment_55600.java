public static void main(String[] args) {
  List<String> al = Arrays.asList(":a", ":a", ":b",
      ":c", ":f", ":f");
  for (int i = 0; i < al.size(); i++) {
    System.out.printf("%d. %s%n", 1 + i, al.get(i));
  }
}