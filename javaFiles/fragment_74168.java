Set<Integer> firstFive = courses.stream()
    .map(c -> c.getTeacher().getTeacherId())
    .distinct().limit(5)
    .collect(Collectors.toSet());
Map<Integer, List<Course>> result = courses.stream()
    .filter(c -> firstFive.contains(c.getTeacher().getTeacherId()))
    .collect(Collectors.groupingBy(c -> c.getTeacher().getTeacherId()));