public class ListTest {

  private static List<int[]> intList;

  public static void main (String[] args) {
    CopyOnWriteArrayList<Integer> cowal = new CopyOnWriteArrayList<Integer>();
    cowal.add(1);
    cowal.add(2);
    cowal.add(3);

    List<Integer> sub = cowal.subList(1, 2);
    cowal.add(4);
    sub.get(0); //throws ConcurrentModificationException
  }
}