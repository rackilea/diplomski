List<Object[]> objects = new ArrayList<>();
objects.add(new Object[] { 0, 1, 2, 3, 4, 5 });
objects.add(new Object[] { 1, 1, 2, 3, 4, 5 });
objects.add(new Object[] { 2, 1, 2, 3, 4, 5 });
objects.add(new Object[] { 0, 6, 7, 8, 9 });

Map<Object, List<Object[]>> map = objects.stream()
    .collect(Collectors.groupingBy(o -> o[0]));

System.out.println(map);