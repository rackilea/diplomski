List<Number> tmp = Arrays.asList(1, 2, 3);
List<Integer> tmp1 = Arrays
    .stream(new Integer[] { 1, 2, 3, 4, 5 })
    .filter(tmp::contains)
    .collect(Collectors.toList());
System.out.println(tmp1);