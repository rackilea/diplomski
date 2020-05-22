import java.util.Arrays;
import java.util.Comparator;

import junit.framework.TestCase;

public class ArrayTest extends TestCase {

    public class Sorter implements Comparator {
        public int compare(Object o1, Object o2){
            String[] arrayOne = (String[])o1;
            String[] arrayTwo = (String[])o2;
            return arrayOne[0].compareTo(arrayTwo[0]);
        }
    }

    public void testSort() {
        String[][] testData = {
                {"Y", "B"},
                {"C", "D"},
                {"A", "B"},
                {"B", "C"},
                {"F", "E"},
                {"E", "Y"},
        };

        Arrays.sort(testData, new Sorter());

        String[][] expectedOutput = {
                {"A", "B"},
                {"B", "C"},
                {"C", "D"},
                {"E", "Y"},
                {"F", "E"},
                {"Y", "B"},
        };

        for(int i = 0; i < testData.length; ++i) {            
            System.out.println(testData[i][0] + " " + testData[i][1]);
            assertEquals(expectedOutput[i][0], testData[i][0]);
            assertEquals(expectedOutput[i][1], testData[i][1]);            
        }
    }
}