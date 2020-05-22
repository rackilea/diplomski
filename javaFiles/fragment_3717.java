Function<List<FileObject>, List<List<FileObject>>> finisher = fileObjs -> {
  MutableLong remaining2 = MutableLong.of(MAX_SIZE_THRESHOLD);
  return StreamEx.of(fileObjs).collapse((a, b) -> {
    if (b.sizeInBytes <= remaining2.value() - a.sizeInBytes) {
      remaining2.subtract(a.sizeInBytes);
      return true;
    } else {
      remaining2.setValue(MAX_SIZE_THRESHOLD);
      return false;
    }
  }, toList()).toList();
};

Map<Integer, Map<Integer, Map<Integer, List<List<FileObject>>>>> result4 = files.stream()
    .collect(groupingBy(f -> f.getYear(),
        groupingBy(f -> f.getMonth(), 
            groupingBy(f -> f.getDay(), collectingAndThen(toList(), finisher)))));