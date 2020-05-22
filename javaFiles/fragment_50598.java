public static <T> int[] getEnumCount(List<T> itemList, int enumSize,
    GetEnumFromType<T> converter) {

  int[] array = new int[enumSize];
  for (T item : itemList) {
    ++array[ converter.getEnum(item).ordinal() ];
  }
  return array;
}