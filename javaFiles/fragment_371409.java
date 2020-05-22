import java.util.*;
import static java.lang.Math.pow;

class NumbersAddition {
  ArrayList<Integer> newarray = new ArrayList<Integer>();
  NumbersAddition(Object unnecessary) {}

  public ArrayList sum(int[]array, int arrayIndex, int newArrayIndex){
     if (arrayIndex<array.length){
       if (newArrayIndex<pow(2,arrayIndex)){
         if(newarray.isEmpty()){
           newarray.add(0);
         }
         newarray.add(newarray.get(newArrayIndex)+array[arrayIndex]);
         sum(array,arrayIndex,newArrayIndex+1);
       } else { 
         // Just do this when newArrayIndex has reached the end:
         sum(array,arrayIndex+1,newArrayIndex-newArrayIndex);
       }
     }
     return newarray;
  }

  public static void main(String[] args) {
     int[] numarray ={1,2,3};
     NumbersAddition num = new NumbersAddition(numarray);
     num.sum(numarray,0,0);
     System.out.println(num.newarray);
  }
}