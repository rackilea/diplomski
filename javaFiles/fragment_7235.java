import java.util.*;

public class Test {

public static long run1() {
  final List<String> myList = Arrays.asList("A", "B", "C", "D");
  final long start = System.nanoTime();
  int sum = 0;
  for (int i = 1000000000; i > myList.size(); i--) sum += i;
  final long stop = System.nanoTime();
  System.out.println("Finish: " + (stop - start)*1e-9 + " ns/op; sum = " + sum);
  return stop-start;
}

public static long run2() {
  final List<String> myList = Arrays.asList("A", "B", "C", "D");
  final long start = System.nanoTime();
  int sum = 0;
  int limit = myList.size();
  for (int i = 1000000000; i > limit; i--) sum += i;
  final long stop = System.nanoTime();
  System.out.println("Finish: " + (stop - start)*1e-9 + " ns/op; sum = " + sum);
  return stop-start;
}

public static void main(String[] args) {
  for (int i=0 ; i<5 ; i++) {
    long t1 = run1();
    long t2 = run2();
    System.out.println("  Speedup = " + (t1-t2)*1e-9 + " ns/op\n");
  }
}

}