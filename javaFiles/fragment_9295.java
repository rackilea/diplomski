List<List<List<String>>> outer = new ArrayList<>();
for (int i = 0; i < 4; i++) {
    List<List<String>> inner = new ArrayList<>();
    outer.add(inner); // <-- note that this inner reference is used on the next two lines.
    inner.add(Arrays.asList("abc", "xyz"));
    inner.add(Arrays.asList("ijk", "mno"));
}
System.out.println(outer);