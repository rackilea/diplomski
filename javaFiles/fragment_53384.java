import java.util.ArrayList;

public class MyNonGUI2  {

   public static void main(String args[]) {
      GetArrayList2 getArrList = new GetArrayList2();
      getArrList.getPeaks();
   }
}

class GetArrayList2 {
   public ArrayList<Integer> PeakList;
   int myLength = 3500;
   double[] myArray = new double[myLength];

   public ArrayList<Integer> getPeaks() {
      for (int h = 0; h < myLength; h++) {
         myArray[h] = Math.sqrt((double) h);
      }
      PeakList = new MakeArrayList2(myArray, myLength).getArrayList();
      System.out.println("in GetArrayList2.getPeaks, PeakList.size() is: "
            + PeakList.size());
      return PeakList;
   }
}

class MakeArrayList2 {
   ArrayList<Integer> myArrayList = new ArrayList<Integer>();

   public MakeArrayList2(double[] myArray, int arrayLength) {
      for (int i = 0; i < arrayLength; i++) {
         myArrayList.add((int) Math.pow(myArray[i], 2));
      }
      System.out.println("in MakeArrayList2, PeakList.size() is: "
            + myArrayList.size());
   }

   public int size() {
      return myArrayList.size();
   }

   public ArrayList<Integer> getArrayList() {
      return new ArrayList<Integer>(myArrayList);
   }
}