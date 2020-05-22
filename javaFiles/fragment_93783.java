List<Result2> results= query.list().stream()
  .collect(groupingBy(Result::getDepartmentName))
  .entrySet().stream()
  .map(e -> new Result2(
    e.getKey(),
    e.getValue().stream().map(Result::getEmployeeName).collect(Collectors.toList())))
  .collect(Collectors.toList());