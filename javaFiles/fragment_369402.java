import java.util.Arrays;
import org.apache.commons.lang.ArrayUtils;

public class RemoveObjectFromArray{

    public static void main(String args[]) {

        //let's create an array for demonstration purpose
        int[] test = new int[] { 101, 102, 103, 104, 105};

        System.out.println("Original Array : size : " + test.length );
        System.out.println("Contents : " + Arrays.toString(test));

        //let's remove or delete an element from Array using Apache Commons ArrayUtils
        test = ArrayUtils.remove(test, 2); //removing element at index 2

        //Size of array must be 1 less than original array after deleting an element
        System.out.println("Size of array after removing an element  : " + test.length);
        System.out.println("Content of Array after removing an object : "
                           + Arrays.toString(test));

    } 

}