public class IteratorDemo {
  public static void main( String[] args ) {
    List<String> list = new ArrayList<>(  );
    list.addAll( Arrays.asList("first", "second", "third" ) );
    Iterator<String> iterator = list.iterator();
    while ( iterator.hasNext() ) {
      String next = iterator.next();
      System.out.println(next);
      iterator.remove();
    }
  }
}