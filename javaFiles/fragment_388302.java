HashSet<Integer> set = new LinkedHashSet<>(Arrays.asList(1, 2, 3, 4, 5));
Iterator<Integer> iter = new ArrayList<>(set).subList(2, set.size())
        .iterator();
while (iter.hasNext()) {
    System.out.println(iter.next());
}