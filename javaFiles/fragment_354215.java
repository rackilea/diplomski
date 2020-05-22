List<String> list[] = new List[5];
Arrays.fill(list, new ArrayList<String>());
list[0].add("hello");
for (List l : list) {
    System.out.println(l);
}