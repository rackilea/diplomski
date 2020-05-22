public class PostProcessComparator<T extends PostProcess> implements Comparator<T> {

  @Override
  public int compare(T p1, T p2) {

    int mainOrderCompare = p1.getOrder().compareTo(p2.getOrder());
    if (mainOrderCompare != 0) {
      return mainOrderCompare;
    } else {
      return p1.getSubOrder().compareTo(p2.getSubOrder());
    }
  }
}