import java.util.Arrays;
import java.util.List;

public class Snippet {

    public static void main(String... s) {
        List<String> lines = Arrays.asList("10.12", "22.56"); // you might not need this line
        double[] nums = new double[lines.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Double.parseDouble(lines.get(i));
            System.out.println(nums[i]);//added just to print data in array
        }
    }

}