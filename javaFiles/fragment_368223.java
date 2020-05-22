import java.util.*;
public class inbetween {
public static void main (String[]args) {
    Scanner in = new Scanner (System.in);
    System.out.println("Enter range of values");
    int x =in.nextInt();
    int y =in.nextInt();
    int[] result = search(x,y);
    for (int i=0;i < result.length; i++)
      System.out.println(result[i]);
}

public static int[] search(int a, int b) {
      int length = (b-a)+1;
    int [] arr = new int [length];
    for(int i=0; i<length; i++)
    {
      a = a+1;
     int c;
     // int count=0;
      c = a%3;
      if (c==0) {
          arr[i] = a;
              }
    }
    return arr;
}
}