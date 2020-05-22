List<Integer> list = Arrays.asList(10, -2, 23, 5, -11, 287, 5, -99);

List<List<Integer>> result = list.stream().collect(
    () -> Arrays.asList(new ArrayList<>(), new ArrayList<>()),
    (l,i) -> { l.get(0).add(Math.max(0, i)); l.get(1).add(Math.min(0, i)); },
    (a,b) -> { a.get(0).addAll(b.get(0)); a.get(1).addAll(b.get(1)); });

System.out.println(result.get(0));
System.out.println(result.get(1));