List<List<String>> outer = new ArrayList<>();
for (int i = 0; i < 4; i++) {
    outer.add(Arrays.asList("abc", "xyz"));
    outer.add(Arrays.asList("ijk", "mno"));
}
System.out.println(outer);