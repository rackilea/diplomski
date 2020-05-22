public static class GenericSortingDTO<T extends Number>
                             implements Comparator<GenericSortingDTO<T>> {
  //your current code here

  @Override
  public int compare(GenericSortingDTO<T> o1, GenericSortingDTO<T> o2) {
    return new BigDecimal(o1.getParameter().toString()).compareTo(new BigDecimal(o2.getParameter().toString()));
  }
}