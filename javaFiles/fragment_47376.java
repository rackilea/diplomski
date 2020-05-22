public class Sort<T extends Comparable<T>> {

    T tmp;


    public void sort(T[] l) {

    for (int i = 0; i < l.length; i++) {
        for (int j = i + 1; j < l.length; j++) {
          if (l[i].compareTo(l[j]) > 0) {
            tmp = l[i];
            l[i] = l[j];
            l[j] = tmp;
          }
        }
    }
      System.out.println(Arrays.asList(l));
    }

    public void sort(List<T> l) {
       T[] array = (T[]) new Comparable[l.size()];
       sort(l.toArray(array));
     }

    public static void main(String[] args) {
      Integer[] i = { 2, 4, 1, 5, 3 };
      Sort<Integer> sortInt = new Sort<Integer>();
      sortInt.sort(i);

      Sort<String> sortString = new Sort<String>();
      List<String> l = Arrays.asList("c", "d", "a", "e", "b");
      sortString.sort(l);
    }
}