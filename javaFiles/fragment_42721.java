import java.util.ArrayList;
import java.util.List;

/**
 * Demo of recursion
 * User: mduffy
 * Date: 10/3/2014
 * Time: 10:56 AM
 * @link http://stackoverflow.com/questions/26179574/recursive-method-not-properly-executing?noredirect=1#comment41047653_26179574
 */
public class RecursionDemo {

    public static void main(String[] args) {
        List<Integer> values = new ArrayList<Integer>();
        for (String arg : args) {
            values.add(Integer.valueOf(arg));
        }
        System.out.println(String.format("input values : %s", values));
        System.out.println(String.format("iterative sum: %d", getSumUsingIteration(values)));
        System.out.println(String.format("recursive sum: %d", getSumUsingRecursion(values)));
    }

    public static int getSumUsingIteration(List<Integer> values) {
        int sum = 0;
        if (values != null) {
            for (int value : values) {
                sum += value;
            }
        }
        return sum;
    }

    public static int getSumUsingRecursion(List<Integer> values) {
        if ((values == null) || (values.size() == 0)) {
            return 0;
        } else {
            if (values.size() == 1) { // This is the stopping condition
                return values.get(0);
            } else {
                return values.get(0) + getSumUsingRecursion(values.subList(1, values.size())); // Here is recursion
            }
        }
    }
}