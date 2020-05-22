public class ArrayLengthTest{    
 public static void main(String []args){
    String[] names = {"Jack", "Bob", "Alice"};
    int[] lengths = new int[names.length];
    for (int i = 0; i < names.length; i++) {
        lengths[i] = names[i].length();
    }
    System.out.println(java.util.Arrays.toString(lengths));// print [4, 3, 5] 
    method1(lengths);// passing length array
    method2(lengths);// passing length array
    method3(lengths);// passing length array
 }
}