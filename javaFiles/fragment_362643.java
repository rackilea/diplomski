import java.util.Arrays;
import org.apache.commons.lang3.ArrayUtils;

public class MyClass {
    public static void main(String args[]) {
        int[] set01 = {1, 2, 3, 4, 5, 6};
        int[] set02 = {1, 2};

        //assume set01 having more elements than set02 array 
        int[] set03 = Arrays.copyOf(set01, set01.length);            

       // sorting array is optional if you know the arrays are sort.
        Arrays.sort(set01);
        Arrays.sort(set02);

        for(int value :set02){
            set03 = ArrayUtils.removeElement(set03, value);          
        }

        for(int value:set03){
           System.out.println("set03 array :"+ value);

        }      
    }
}