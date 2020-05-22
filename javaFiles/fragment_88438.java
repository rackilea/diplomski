import com.google.common.collect.HashMultimap;
import com.google.common.collect.SetMultimap;

  public static void main(String[] args) 
  {
    final SetMultimap<Integer, Integer> foo = HashMultimap.create();
    foo.put( 1,35);
    foo.put(   1,30);
    foo.put(  1,20);
    foo.put(  2,10);
    foo.put(  3,40);
    foo.put(  3,25);
    foo.put(  3,15);
    System.out.println(foo);
  }