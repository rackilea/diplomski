import java.util.Arrays;
import java.util.Comparator;

public class StupidComparator { 
    public static void main(String[] args) {
        // this is a value used (bound) by the inner class
        // note that it needs to be "final"
        final int numberToCompareTo=10;

        // this is an inner class that acts like a closure and uses one bound value
        Comparator<Integer> comp=new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                int result=0;
                if (a<numberToCompareTo) result=result-1;
                if (b<numberToCompareTo) result=result+1;
                return result;
            }
        };

        Integer[] array=new Integer[] {1,10, 5 , 15, 6 , 20, 21, 3, 7};

        // this is a function call that takes the inner class "closure" as a parameter
        Arrays.sort(array,comp);

        for (int i:array) System.out.println(i);
    }
}