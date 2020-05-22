$ cat Test.java
public class Test {
  public static void main(String[] args) {
    System.out.println(System.in.getClass());
  }
}
$ javac Test.java 
$ java Test 
class java.io.BufferedInputStream
$