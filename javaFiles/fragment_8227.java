public class A {
 static final long tooth#1 = 1L;

 static long tooth#2(long tooth#3){
  System.out.println(++tooth#3);
  return ++tooth#3;
 }

 public static void main(String args[]){
  System.out.println(tooth#1);
  final long tooth#4 = 2L;
  new A().tooth#2(tooth#4);
  System.out.println(tooth#4);
}