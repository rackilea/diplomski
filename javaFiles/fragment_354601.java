import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Jagged {
    public static boolean isUpper(int[][] array){
        for (int i = 0; i < array.length; i++) {
            if(array.length == array[0].length){
                System.out.println("yes");
                return true;
            }
        }
        System.out.println("no");
        return false;
    }
  public static void main(String args[]) {
    int myA[][] = {{3,4,5},{6,7},{8}};
    int myB[][] = {{8},{6,7},{5,4,3}};
    isUpper(myA);
  }

 }