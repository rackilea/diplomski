public int compare(Object o1, Object o1){
  ActualType a1 = (ActualType) o1;
  ActualType a2 = (ActualType) o2;
  SortedOrderMap map = getSortOrderMap(); //cached of course
  Integer l1 = map.get(a1.getLying());
  Integer l2 = map.get(a2.getLying());
  return l1.compareTo(l2);
}