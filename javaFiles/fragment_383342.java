import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.assertEquals;    
import org.junit.Test;
import org.junit.runner.RunWith;    
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class countUniqueNumsParamTest {

    @SuppressWarnings({ "unused", "deprecation" })
    private static final Object[] countUniqueNumbers () {
        return $(
                // Parameters are (1,2),  1=expected result count, 2= input array
                    $(1,new int[]{0}),      //Test Case 1
                    $(0,new int[]{}),       //Test Case 2
                    $(0,new int[]{0,0}),    //Test Case 3           
                    $(0,new int[]{0,0,0}),  //Test Case 4

                    $(1,new int[]{0,1,1,1}),    //Test Case 5
                    $(1,new int[]{1,1,1,0}),    //Test Case 6
                    $(2,new int[]{1,0,2,1}),    //Test Case 7
                    $(4,new int[]{0,1,2,3})     //Test Case 8

                    );
    }
    @Test
    @Parameters(method="countUniqueNumbers")
    public void test(int unique, int[] nums) {
        countUniqueNums cun = new countUniqueNums();
        assertEquals(unique, cun.countUnique(nums));
    }
}